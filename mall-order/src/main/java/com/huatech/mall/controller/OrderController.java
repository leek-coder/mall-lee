package com.huatech.mall.controller;

import com.huatech.mall.constants.ApiBaseConstants;
import com.huatech.mall.entity.order.Order;
import com.huatech.mall.feign.IProductFeignService;
import com.huatech.mall.request.QuickOrderReq;
import com.huatech.mall.response.ProductRes;
import com.huatech.mall.response.ResponseResult;
import com.huatech.mall.service.IOrderService;
import com.huatech.mall.utils.BaseController;
import com.huatech.mall.utils.MD5;
import com.huatech.mall.utils.RedisUtils;
import com.huatech.mall.utils.VerifyCodeImgUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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


    @PostMapping(value = "/{token}/generateOrder")
    public ResponseResult createOrder(@RequestBody QuickOrderReq quickOrderReq, @PathVariable("token") String token) {
        quickOrderReq.setToken(token);
        Order order = orderService.quickCreateOrder(quickOrderReq);
        //返回下单成功
        return ResponseResult.success(order);
    }


    /**
     * 生成防刷二维码
     *
     * @param response
     * @param productId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/verifyCode", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult verifyCode(HttpServletResponse response,
                                     @RequestParam("productId") Long productId,
                                     @RequestHeader("userId") Long userId) {
        try {
            VerifyCodeImgUtil.VerifyCodeInfo imageInfo = VerifyCodeImgUtil.createVerifyCode();
            log.info("验证码答案:{}", imageInfo.getResult());
            //验证码答案写入到redis
            redisUtils.setEx(ApiBaseConstants.RedisKeyPrefix.MIAOSHA_VERIFY_CODE_PREFIX + userId + ":" + productId
                    , imageInfo.getResult().toString()
                    , 300
                    , TimeUnit.SECONDS);

            response.setHeader("Content-Type", "image/jpeg");
            OutputStream out = response.getOutputStream();
            ImageIO.write(imageInfo.getBufferedImage(), "JPEG", out);
            out.flush();
            out.close();
            return null;
        } catch (Exception e) {
            return ResponseResult.failure("生成验证嘛失败", 500);
        }
    }


    /**
     * 根据验证码结果获取token
     *
     * @param request
     * @param productId
     * @param userId
     * @param verifyCode
     * @return
     */
    @RequestMapping(value = "/token", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult obtainToken(HttpServletRequest request
            , @RequestParam("productId") Long productId
            , @RequestParam("userId") Long userId
            , @RequestParam Integer verifyCode) {

        //用redis限流，限制接口1分钟最多访问10000次
        String requestURI = request.getRequestURI().toString();
        Long requestNum = redisUtils.incrBy(requestURI, 1L);
        if (requestNum == 1) {
            redisUtils.expire(requestURI, 60, TimeUnit.SECONDS);
        } else if (requestNum > 10000) {
            return ResponseResult.failure("访问超载，请稍后再试", 500);
        }

        String verifyCodeKey = ApiBaseConstants.RedisKeyPrefix.MIAOSHA_VERIFY_CODE_PREFIX + userId + ":" + productId;

        //校验验证码，防止接口被刷
        Integer redisCode = Integer.parseInt(redisUtils.get(verifyCodeKey));

        if (StringUtils.isEmpty(redisCode) || !redisCode.equals(verifyCode)) {
            return ResponseResult.failure("验证码错误", 500);
        }
        //验证成功,删除该验证码
        redisUtils.delete(verifyCodeKey);
        //创建token
        String token = MD5.md5(UUID.randomUUID().toString());
        redisUtils.setEx(ApiBaseConstants.RedisKeyPrefix.MIAOSHA_TOKEN_PREFIX + userId + ":" + productId
                , token
                , 300
                , TimeUnit.SECONDS);
        return ResponseResult.success(token);
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