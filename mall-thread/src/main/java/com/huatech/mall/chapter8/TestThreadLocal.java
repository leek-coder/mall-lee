package com.huatech.mall.chapter8;

/**
 * @author like
 * @date 2021-01-28 11:49 下午
 **/
public class TestThreadLocal {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "Netty";
        }
    };

    public static void main(String[] args) {
        threadLocal.set("leek");
        try {
            Thread.sleep(1000L);
            String s = threadLocal.get();
            System.out.println("s=" + s);
            new Thread(() -> {
                System.out.println("当前线程:" + Thread.currentThread().getName() + "====" + threadLocal.get());
            }).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}