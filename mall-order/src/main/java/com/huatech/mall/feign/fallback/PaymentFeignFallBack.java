package com.huatech.mall.feign.fallback;

import com.huatech.mall.feign.IPaymentFeignService;
import com.huatech.mall.response.ResponseResult;
import org.springframework.stereotype.Component;


/**
 * @author like
 * @date 2020-06-22 4:18 下午
 **/
@Component
public class PaymentFeignFallBack implements IPaymentFeignService {


    @Override
    public ResponseResult<Integer> receiveMessage(String json) {
        return ResponseResult.failure("调用远程服务失败", -1);
    }

}