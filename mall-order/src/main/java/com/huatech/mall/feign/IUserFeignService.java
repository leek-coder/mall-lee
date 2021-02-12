package com.huatech.mall.feign;

import com.huatech.mall.feign.fallback.UserFeignFallBack;
import com.huatech.mall.response.AddressRes;
import com.huatech.mall.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 远程调用用户服务
 *
 * @author like
 * @date 2020-06-23 11:01 上午
 **/
@FeignClient(name = "user-service", fallback = UserFeignFallBack.class)
public interface IUserFeignService {


    /**
     * 获取用户默认地址
     * @param json
     * @return
     */
    @PostMapping(value = "/api/mall/address/default", consumes = "application/json")
    ResponseResult<AddressRes> defaultAddress(@RequestBody String json);
}