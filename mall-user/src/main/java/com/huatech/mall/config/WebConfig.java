package com.huatech.mall.config;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.huatech.mall.block.UserControllerBlockUtils;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author like
 * @date 2020-12-21 11:00 下午
 **/
@Configuration
public class WebConfig {

    /**
     * ribbon整合sentinel
     *
     * @return
     */
    @Bean
    @LoadBalanced
    @SentinelRestTemplate(blockHandler = "", blockHandlerClass = UserControllerBlockUtils.class, fallback = "",
            fallbackClass = Object.class)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}