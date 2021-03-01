package com.huatech.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 *
 * @author like
 * @date 2019-11-28 4:46 下午
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.huatech.mall.mapper")
@ComponentScan(basePackages = {"com.huatech.mall.exception", "com.huatech.mall"})
public class MallProductEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallProductEsApplication.class, args);
    }

}
