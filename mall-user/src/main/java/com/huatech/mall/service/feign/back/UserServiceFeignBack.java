package com.huatech.mall.service.feign.back;

import com.huatech.mall.service.IUserService;
import org.springframework.stereotype.Component;

/**
 * 熔断返回
 *
 * @author like
 * @date 2019-11-28 5:53 下午
 **/
@Component
public class UserServiceFeignBack implements IUserService {
    @Override
    public String detail() {
        return "fall back";
    }
}