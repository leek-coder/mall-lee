package com.huatech.mall.chapter4;

/**
 * @author like
 * @date 2021-01-18 11:02 上午
 **/
public class TicketBankRunnable implements Runnable {


    private int index = 1;

    /**
     * 共享数据
     */
    private final static int MAX = 500;

    private final Object MONITOR = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (MONITOR) {
                if (index > MAX) {
                    break;
                }
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "出票=" + (index++));
            }
        }
    }
}