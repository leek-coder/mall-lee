package com.huatech.mall.chapter3;

/**
 * @author like
 * @date 2021-01-18 9:35 上午
 * 优雅的中断线程
 **/
public class ThreadCloseGraceFul {

    private static class Worker extends Thread {

        /**
         * 标记开关
         */
        private volatile boolean start = true;

        @Override
        public void run() {
            while (start) {

            }
        }

        public void shutdown() {
            this.start = false;
        }
    }

    public static void main(String[] args) {

        Worker worker = new Worker();
        worker.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.shutdown();
    }

}