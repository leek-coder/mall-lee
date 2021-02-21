package com.huatech.mall.config;

import com.huatech.mall.component.MyAspectJ;
import com.huatech.mall.service.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author like
 * @date 2021-02-18 2:13 下午
 **/

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.huatech.mall.component")
public class MainConfig {

    @Bean
    public MyAspectJ myAspectJ() {
        return new MyAspectJ();
    }

    @Bean
    public PersonServiceImpl personService() {
        return new PersonServiceImpl();
    }
}

