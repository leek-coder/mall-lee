package com.huatech.mall;

import com.huatech.dubbo.IPersonService;
import com.huatech.dubbo.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author like
 * @date 2021-02-04 8:34 上午
 **/
public class DubboClientMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();
        IPersonService userService = (IPersonService)context.getBean("personService");
        userService.sysPerson("leek");
    }
}