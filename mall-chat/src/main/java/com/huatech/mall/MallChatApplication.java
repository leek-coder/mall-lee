package com.huatech.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
/**
 *
 * @author like
 * @date 2020-08-20 8:07 下午
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.huatech.mall.dao")
@ComponentScan(basePackages = {"com.jrx.common.exception", "com.huatech.mall","com.jrx.common.utils"})
@EnableFeignClients
@EnableDiscoveryClient
public class MallChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallChatApplication.class, args);
    }

}
