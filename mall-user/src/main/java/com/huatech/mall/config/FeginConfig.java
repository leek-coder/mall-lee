package com.huatech.mall.config;

import com.huatech.mall.interceptor.FeignInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author like
 * @date 2020-12-15 11:14 下午
 **/
@Configuration
public class FeginConfig {

    @Bean
    public FeignInterceptor feignInterceptor() {
        return new FeignInterceptor();
    }
}