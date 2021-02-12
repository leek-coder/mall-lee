package com.huatech.mall.feign.fallback;

import com.huatech.mall.feign.IUserFeignService;
import com.huatech.mall.response.AddressRes;
import com.huatech.mall.response.ResponseResult;
import org.springframework.stereotype.Component;

/**
 * @author like
 * @date 2020-06-22 4:18 下午
 **/
@Component
public class UserFeignFallBack implements IUserFeignService {


    @Override
    public ResponseResult<AddressRes> defaultAddress(String json) {
        return ResponseResult.failure(-1, "获取默认地址失败");
    }
}