package com.huatech.mall.feign;

import com.huatech.mall.feign.fallback.PaymentFeignFallBack;
import com.huatech.mall.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author like
 * @date 2020-06-22 4:18 下午
 **/
@FeignClient(name = "payment-service", fallback = PaymentFeignFallBack.class)
public interface IPaymentFeignService {

    /**
     * 发送预订单信息
     *
     * @param json
     * @return
     */
    @GetMapping(value = "/api/mall/distribute/message/receive", consumes = "application/json")
    ResponseResult<Integer> receiveMessage(@RequestBody String json);


}