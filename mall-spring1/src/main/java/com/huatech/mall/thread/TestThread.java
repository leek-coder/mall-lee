package com.huatech.mall.thread;

import java.util.concurrent.Semaphore;

/**
 * @author like
 * @date 2021-02-22 8:37 下午
 **/
public class TestThread {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(2);
        semaphore.acquire();
        semaphore.release();

    }
}