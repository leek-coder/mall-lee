package com.huatech.mall.chapter5;

/**
 * @author like
 * @date 2021-01-18 1:49 下午
 * 此代码在多个生产者，多个消费者情况下会有问题
 **/
public class ProduceAndConsumeTest {

    private int index = 0;
    final private Object LOCK = new Object();
    private volatile boolean isProduce = false;

    public void produce() {
        synchronized (LOCK) {
            //已经生产
            if (isProduce) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                index++;
                System.out.println("P->" + index);
                LOCK.notify();
                isProduce = true;
            }
        }
    }

    public void consume() {
        synchronized (LOCK) {
            //消费
            if (isProduce) {
                System.out.println("C->" + index);
                LOCK.notify();
                isProduce = false;
            } else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    public static void main(String[] args) {
        ProduceAndConsumeTest pc = new ProduceAndConsumeTest();
        new Thread(){
            @Override
            public void run() {
                while (true){
                    pc.produce();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    pc.consume();
                }
            }
        }.start();

    }
}