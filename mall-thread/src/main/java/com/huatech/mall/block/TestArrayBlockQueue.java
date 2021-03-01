package com.huatech.mall.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author like
 * @date 2021-02-28 5:32 下午
 **/
public class TestArrayBlockQueue {
    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);
        blockingQueue.put("leek");
        ThreadPoolExecutor  executor = new ThreadPoolExecutor(5,10,10L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));
        executor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}