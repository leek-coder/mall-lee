package com.huatech.mall.chapter9;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author like
 * @date 2021-01-30 10:48 下午
 **/
public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        testFuture1();
    }

    private static void testFuture1() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        AtomicReference<String> name = new AtomicReference<>("like");
        Future<?> future = executorService.submit(() -> {
            try {
                Thread.sleep(1000L);
                name.set("张三");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, name);
        Object o = future.get();
        System.out.println("o=" + o);
//        executorService.shutdown();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    }
}