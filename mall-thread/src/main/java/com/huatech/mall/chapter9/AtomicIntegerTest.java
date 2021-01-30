package com.huatech.mall.chapter9;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author like
 * @date 2021-01-30 2:32 下午
 **/
public class AtomicIntegerTest {

    private static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(10),
                new ThreadPoolExecutor.AbortPolicy());
        IntStream.range(0, 20).boxed().forEach(e -> {
            executor.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    count.getAndIncrement();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            });
        });
        executor.shutdown();
        try {
            executor.awaitTermination(10,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==========over==========");
        System.out.println(count.get());


    }
}