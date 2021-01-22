package com.huatech.mall.chapter4;

/**
 * @author like
 * @date 2021-01-18 11:15 上午
 **/
public class SynchronizedTest {

    private static final Object MONITOR = new Object();

    public static void main(String[] args) {

        Runnable runnable = () -> {
            try {
                synchronized (MONITOR) {
                    Thread.sleep(200_1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
    }
}