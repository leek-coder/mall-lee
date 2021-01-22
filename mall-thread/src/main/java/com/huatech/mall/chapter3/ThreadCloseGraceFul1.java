package com.huatech.mall.chapter3;

/**
 * @author like
 * @date 2021-01-18 9:35 上午
 * 优雅的中断线程
 **/
public class ThreadCloseGraceFul1 {

    private static class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
//                    if(Thread.interrupted()){
//                        break;
//                    }
                } catch (InterruptedException e) {
                    //终止线程执行
                    break;
                }
            }
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
        worker.interrupt();

    }

}