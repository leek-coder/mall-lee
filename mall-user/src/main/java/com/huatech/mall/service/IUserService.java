package com.huatech.mall.service;

import com.huatech.mall.service.feign.back.UserServiceFeignBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 用户服务service
 *
 * @author like
 * @date 2019-11-28 5:52 下午
 **/
@FeignClient(name = "mall-product", fallback = UserServiceFeignBack.class)
public interface IUserService {


    /**
     * test
     *
     * @return
     */
    @GetMapping(value = "/bankService/test")
    public String detail();
}