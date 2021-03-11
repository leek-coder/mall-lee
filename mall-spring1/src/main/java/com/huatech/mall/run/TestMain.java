package com.huatech.mall.run;

import com.huatech.mall.config.MainConfig;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author like
 * @date 2021-02-18 3:22 下午
 **/
public class TestMain {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        applicationContext.publishEvent(new ApplicationEvent(new String("我发布了事件")) {

        });
        applicationContext.close();

        ReentrantLock lock = new ReentrantLock();
        lock.lock();


    }
}