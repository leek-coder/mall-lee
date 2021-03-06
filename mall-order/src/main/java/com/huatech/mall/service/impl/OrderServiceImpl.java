package com.huatech.mall.service.impl;

import com.huatech.mall.component.LocalCache;
import com.huatech.mall.constants.ApiBaseConstants;
import com.huatech.mall.entity.DisTransMessage;
import com.huatech.mall.entity.order.Order;
import com.huatech.mall.entity.order.SubOrder;
import com.huatech.mall.enums.ApiErrorCodeEnum;
import com.huatech.mall.exception.ExceptionCustomer;
import com.huatech.mall.feign.*;
import com.huatech.mall.feign.request.UserDefaultAddressReq;
import com.huatech.mall.mapper.order.OrderMapper;
import com.huatech.mall.request.QuickOrderReq;
import com.huatech.mall.response.AddressRes;
import com.huatech.mall.response.ProductRes;
import com.huatech.mall.response.ResponseResult;
import com.huatech.mall.service.IOrderService;
import com.huatech.mall.service.ISendService;
import com.huatech.mall.service.ISubOrderService;
import com.huatech.mall.utils.JsonUtils;
import com.huatech.mall.utils.RedisUtils;
import com.huatech.mall.utils.SnowFlake;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 下单服务实现
 *
 * @author like
 * @date 2020-06-23 12:42 上午
 **/
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {


    @Resource
    private OrderMapper orderMapper;

    @Resource
    private IUserFeignService userFeignService;

    @Resource
    private IProductFeignService productFeignService;

    @Resource
    private IProductStoreFeignService productStoreFeignService;

    @Autowired
    private ISendService sendService;

    @Autowired
    private SnowFlake snowFlake;

    private static final String ORDER_STATUS = "1";
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private ISubOrderService subOrderService;

    @Resource
    private IPaymentFeignService paymentFeignService;

    @Autowired
    private LocalCache<Boolean> localCache;


    @Override
    public Order quickCreateOrder(QuickOrderReq quickOrderReq) {

        if (StringUtils.isBlank(quickOrderReq.getProductId())) {
            throw new ExceptionCustomer(ApiErrorCodeEnum.PRODUCT_ID_NOT_NULL);
        }
//        if (StringUtils.isNotBlank(redisUtils.get(ApiBaseConstants.RedisKeyPrefix.USER_HAD_ORDER_PRODUCT + quickOrderReq.getUserId()))) {
//            throw new ExceptionCustomer("该用户已经抢够过商品", -1);
//        }
        //0：从内存里取出商品有无库存标记
        if (confirmCheck(quickOrderReq.getProductId(), quickOrderReq.getToken())) {
            throw new ExceptionCustomer("商品已经抢完", -1);
        }
        //先从redis取用户是否存入默认的收货地址
        AddressRes addressRes;
        String addressString = redisUtils.get(ApiBaseConstants.USER_DEFAULT_ADDRESS + quickOrderReq.getUserId());
        //1:先查询用户是否有默认地址 将用户的默认地址加到缓存
        if (StringUtils.isBlank(addressString)) {
            UserDefaultAddressReq defaultAddress = new UserDefaultAddressReq();
            defaultAddress.setUserId("3");
            FeignPredicate<AddressRes> addressResFeignPredicate = () -> userFeignService.defaultAddress(JsonUtils.toString(defaultAddress));
            if (null == addressResFeignPredicate.getRes(addressResFeignPredicate)) {
                throw new ExceptionCustomer("查询用户默认地址失败", ApiBaseConstants.REMOTE_FAIL);
            }
            addressRes = addressResFeignPredicate.getRes(addressResFeignPredicate);
            redisUtils.set(ApiBaseConstants.USER_DEFAULT_ADDRESS + quickOrderReq.getUserId(), JsonUtils.toString(addressRes));
        } else {
            addressRes = JsonUtils.toObjectBean(addressString, AddressRes.class);
        }
        //库存缓存预判断   查询redis也会有开销，远程调用的开销
        if (!preSubtractionOfProductStock(quickOrderReq.getProductId())) {
            throw new ExceptionCustomer("商品已经抢完", -1);
        }
        //2：商品是否存在
        FeignPredicate<ProductRes> productResFeignPredicate = () -> productFeignService.findProductStore(quickOrderReq.getProductId());
        if (null == productResFeignPredicate.getRes(productResFeignPredicate)) {
            throw new ExceptionCustomer("商品不存在", ApiBaseConstants.REMOTE_FAIL);
        }
        ProductRes productRes = productResFeignPredicate.getRes(productResFeignPredicate);
        //3：判断库存是否足够
        if (productRes.getProductStock() <= 0) {
            //库存不足
            throw new ExceptionCustomer("商品库存不足", ApiBaseConstants.REMOTE_FAIL);
        }
        //4:组装订单调用交易服务，库存服务
        Order order = confirmOrder(productRes, addressRes, quickOrderReq.getUserId());
        return order;
    }

    /**
     * 检查是否有库存
     *
     * @param productId
     * @return
     */
    private boolean confirmCheck(String productId, String token) {

        //校验token  这段代码userId 需要更改
        String redisToken = redisUtils.get(ApiBaseConstants.RedisKeyPrefix.MIAOSHA_TOKEN_PREFIX + "userId" + ":" + productId);
        if (org.springframework.util.StringUtils.isEmpty(redisToken) || !redisToken.equals(token)) {
            throw new ExceptionCustomer("非法token");
        }

        Boolean flag = localCache.getCache(ApiBaseConstants.RedisKeyPrefix.MIAOSHA_STOCK_CACHE_PREFIX + productId);
        if (flag != null && flag) {
            return true;
        }
        //从redis缓存当中取出当前要购买的商品库存
        Integer stock = Integer.parseInt(redisUtils.get(ApiBaseConstants.RedisKeyPrefix.MIAOSHA_STOCK_CACHE_PREFIX + productId));
        if (stock == null || stock <= 0) {
            localCache.setLocalCache(ApiBaseConstants.RedisKeyPrefix.MIAOSHA_STOCK_CACHE_PREFIX + productId, true);
            return true;
        }
        return false;
    }

    //还原库存
    public void incrRedisStock(Long productId) {
        if (redisUtils.hasKey(ApiBaseConstants.RedisKeyPrefix.MIAOSHA_STOCK_CACHE_PREFIX + productId)) {
            redisUtils.incrBy(ApiBaseConstants.RedisKeyPrefix.MIAOSHA_STOCK_CACHE_PREFIX + productId, 1L);
        }
    }

    /**
     * 下订单   下单的时候做异步化  使用rabbitmq
     *
     * @param productRes
     * @param addressRes
     * @param userId
     * @return
     */
    private Order confirmOrder(ProductRes productRes, AddressRes addressRes, Long userId) {

        //创建订单信息
        Order order = createOrder(productRes, addressRes, userId);
        //给中台系统发送预订单mq消息
//        DisTransMessage disTransMessage = new DisTransMessage(order.getOrderNo(), null, "1", 1);
//        ResponseResult<Integer> response = paymentFeignService.receiveMessage(JsonUtils.toString(disTransMessage));
//        if (null == response || response.getCode() == -1) {
//            log.info("发送预订单信息失败");
//            //还原缓存里的库存
//            incrRedisStock(Long.parseLong(productRes.getProductId()));
//            //清除掉本地localCache已经售完的标记
//            localCache.remove(ApiBaseConstants.RedisKeyPrefix.MIAOSHA_STOCK_CACHE_PREFIX+productRes.getProductId());
//            //通知服务群,清除本地售罄标记缓存
//            if(shouldPublishCleanMsg(productRes.getProductId())){
//                redisUtils.publish("cleanLocalCache",productRes.getProductId());
//            }
//            throw new ExceptionCustomer("发送预订单信息失败", -1);
//        }
        //异步下单
        try {
            sendService.asynOrder(order);
        } catch (Exception e) {
            log.info("创建订单失败");
            //还原缓存里的库存
            incrRedisStock(Long.parseLong(productRes.getProductId()));
            //清除掉本地localCache已经售完的标记
            localCache.remove(ApiBaseConstants.RedisKeyPrefix.MIAOSHA_STOCK_CACHE_PREFIX + productRes.getProductId());
            //通知服务群,清除本地售罄标记缓存
            if (shouldPublishCleanMsg(productRes.getProductId())) {
                redisUtils.publish("cleanLocalCache", productRes.getProductId());
            }
            throw new ExceptionCustomer("创建订单失败", -1);
        }
//        //减库存
//        //解决分布式事务
//        // TODO:插入日志表log(orderId,productId,stockCount...)
//        ResponseResult<Integer> result = productStoreFeignService.updateProductStock(productRes.getProductId());
//        if (result.getData() == null || result.getData() < 0) {
//            throw new ExceptionCustomer("更新库存失败", -1);
//        }
        return order;
    }

    /**
     * 拼接主订单信息
     *
     * @param productRes
     * @param addressRes
     * @param userId
     * @return
     */
    private Order createOrder(ProductRes productRes, AddressRes addressRes, Long userId) {

        //拼接主订单信息
        Order order = new Order();
        //生成订单号
        order.setOrderNo(snowFlake.nextId() + "");
        order.setCreateTime(new Date());
        order.setRemark("秒杀订单");
        order.setStatus(ORDER_STATUS);
        order.setPrice(productRes.getProductNowPrice());
        order.setNum(1);
        order.setAddressId(addressRes.getId());
        order.setUserId(userId);
        order.setCreateUser(userId);
        order.setSource(ORDER_STATUS);
        return order;
    }

    /**
     * 预减商品库存
     *
     * @param productId
     * @return
     */
    private boolean preSubtractionOfProductStock(String productId) {

        Long stock = redisUtils.decrBy(ApiBaseConstants.RedisKeyPrefix.PRODUCT_STOCK + "_" + productId);
        if (stock == null || stock < 0) {
            incrRedisStock(Long.parseLong(productId));
            return false;
        }
        return true;
    }

    /**
     * 判断是否需要通知服务群,清除本地售罄标记缓存
     *
     * @param productId
     * @return
     */
    public boolean shouldPublishCleanMsg(String productId) {
        Integer stock = Integer.parseInt(redisUtils.get(ApiBaseConstants.RedisKeyPrefix.MIAOSHA_STOCK_CACHE_PREFIX + productId));
        return (stock == null || stock <= 0);
    }

    /**
     * 提交订单
     *
     * @param order
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void submitOrder(Order order) {
        orderMapper.insertSelective(order);
        //创建订单明细
        SubOrder subOrder = new SubOrder();
        subOrder.setCreateTime(new Date());
        subOrder.setUserId(order.getUserId());
        subOrder.setProductNum(1);
        subOrder.setPrice(order.getPrice());
        subOrder.setStatus(ORDER_STATUS);
        subOrder.setSource(ORDER_STATUS);
        subOrder.setOrderNo(order.getOrderNo());
        //这个赋值是错误的，只为了插入数据时不报错
        subOrder.setProductId(order.getOrderNo());
        subOrderService.insertSubOrderInfo(subOrder);
    }


}