package com.huatech.mall.chapter4;

/**
 * @author like
 * @date 2021-01-18 1:11 下午
 **/
public class SynchronizedTest2 {
    public static void main(String[] args) {

        ThisLock thisLock = new ThisLock();
        new Thread(() -> {
            thisLock.m1();
        }, "T1").start();

        new Thread(() -> {
            thisLock.m2();
        }, "T2").start();

    }
}

class ThisLock {

    private final static Object MONITOR = new Object();
    /**
     * lock is this
     */
    public synchronized void m1() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * lock is monitor
     */
    public void m2() {
        try {
            synchronized (MONITOR) {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}