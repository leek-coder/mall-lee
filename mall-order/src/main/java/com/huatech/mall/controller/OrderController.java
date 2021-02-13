package com.huatech.mall.controller;

import com.huatech.mall.constants.ApiBaseConstants;
import com.huatech.mall.entity.order.Order;
import com.huatech.mall.feign.IProductFeignService;
import com.huatech.mall.request.QuickOrderReq;
import com.huatech.mall.response.ProductRes;
import com.huatech.mall.response.ResponseResult;
import com.huatech.mall.service.IOrderService;
import com.huatech.mall.utils.BaseController;
import com.huatech.mall.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 下单控制器
 *
 * @author like
 * @date 2020-06-22 11:54 下午
 **/
@RestController
@RequestMapping(value = "/v1/order")
@Slf4j
public class OrderController extends BaseController implements InitializingBean {


    @Autowired
    private IOrderService orderService;

    @Resource
    private IProductFeignService productFeignService;

    @Autowired
    private RedisUtils redisUtils;



    @PostMapping(value = "/generateOrder")
    public ResponseResult createOrder(@RequestBody QuickOrderReq quickOrderReq) {
        Order order = orderService.quickCreateOrder(quickOrderReq);
        //返回下单成功
        return ResponseResult.success(order);
    }

    //查看秒杀结果


    /**
     * 加载所有的秒杀商品到redis缓存中
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {

        //查询所有秒杀的商品
        ResponseResult<List<ProductRes>> result = productFeignService.list();
        List<ProductRes> res = result.getData();
        if (CollectionUtils.isNotEmpty(res)) {
            res.stream().forEach(e -> {
                //redis的key为前缀+productId，value为库存数量
                redisUtils.set(ApiBaseConstants.RedisKeyPrefix.MIAOSHA_STOCK_CACHE_PREFIX + "_" + e.getProductId(), e.getProductStock() + "");
            });
        }

    }
}