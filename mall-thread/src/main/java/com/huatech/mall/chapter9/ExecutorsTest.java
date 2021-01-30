package com.huatech.mall.chapter9;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author like
 * @date 2021-01-30 5:22 下午
 **/
public class ExecutorsTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Callable<Integer>> runs = IntStream.range(0, 20).boxed().map(e ->
                (Callable<Integer>) () -> {
                    Thread.sleep(1000L);
                    return e;
                }
        ).collect(Collectors.toList());
        executor.invokeAll(runs);
    }
}