package com.huatech.mall.chapter3;

/**
 * @author like
 * @date 2021-01-18 10:32 上午
 **/
public class ThreadServiceTest {
    public static void main(String[] args) {

        long currentTime = System.currentTimeMillis();
        ThreadService threadService = new ThreadService();
        threadService.execute(() -> {
            //load a very heavy resource
//            while (true) {
//            }
            try {
                System.out.println("do");
                //模拟工作线程5s执行完任务
                Thread.sleep(4000);
                System.out.println("end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadService.shutdown(10000);
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - currentTime);

    }
}