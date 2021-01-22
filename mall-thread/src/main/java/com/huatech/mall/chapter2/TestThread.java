package com.huatech.mall.chapter2;

import java.util.Arrays;

/**
 * @author like
 * @date 2021-01-17 11:21 上午
 **/
public class TestThread {
    public static void main(String[] args) {

        Thread t1 = new Thread(new PersonThread(),"myName"){
        };
        t1.start();

        Thread t2 = new Thread();
        //设置线程为守护线程
        t2.setDaemon(true);
        t2.start();
        System.out.println(t2.getName());
        
        System.out.println(t1.getName());

        new Thread(()->{
            System.out.println();
        },"myName1").start();


        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.activeCount());

        Thread []threads = new Thread[threadGroup.activeCount()];

        Arrays.asList(threads).forEach(System.out::println);




    }
}