package com.jrx.common.constants;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author like
 * @date 2021-01-01 7:23 下午
 **/
public class BasicConstants {
    public static Integer SERVICE_TYPE = 1001;

    /**
     * 构建索引成功
     */
    public static Integer BUILD_INDEX_SUCCESS = 200;
    /**
     * 统一线程池
     * 核心线程10个
     * 最大线程1000个
     */
    static BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(1000);
    public final static ThreadPoolExecutor executorService =
            new ThreadPoolExecutor(10, 100, 1000L, TimeUnit.SECONDS, blockingQueue);
}