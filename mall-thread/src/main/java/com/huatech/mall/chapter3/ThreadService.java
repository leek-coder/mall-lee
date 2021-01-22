package com.huatech.mall.chapter3;

/**
 * @author like
 * @date 2021-01-18 10:06 上午
 **/
public class ThreadService {

    private Thread executeThread;

    private boolean finished = false;

    public void execute(Runnable task) {
        executeThread = new Thread() {
            @Override
            public void run() {
                Thread runner = new Thread(task);
                //设置t1为守护线程
                runner.setDaemon(true);
                runner.start();
                try {
                    //让调用runner的线程让出cpu执行权
                    runner.join();
                    System.out.println("AAAA");
                    finished = true;
                } catch (InterruptedException e) {
                }
            }
        };
        executeThread.start();
    }

    public void shutdown(long mills) {
        long currentTime = System.currentTimeMillis();
        while (!finished) {
            if ((System.currentTimeMillis() - currentTime) >= mills) {
                System.out.println("任务超时，需要结束");
                executeThread.interrupt();
                break;
            }
        }
        finished = false;
    }

    public Thread getExecuteThread(){
        return executeThread;
    }
}