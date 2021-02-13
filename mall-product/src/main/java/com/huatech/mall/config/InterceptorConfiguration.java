package com.huatech.mall.config;

import com.huatech.mall.interceptor.BloomFilterInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author like
 * @date 2020-06-22 3:34 下午
 **/
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        registry.addInterceptor(authInterceptorHandler())
                .addPathPatterns("/v1/pms/productInfo/**");
    }

    @Bean
    public BloomFilterInterceptor authInterceptorHandler(){
        return new BloomFilterInterceptor();
    }
}
