package com.huatech.mall.chapter2;

/**
 * @author like
 * @date 2021-01-17 11:23 上午
 **/
public class PersonThread implements  Runnable {
    @Override
    public void run() {
        System.out.println("person");
    }
}