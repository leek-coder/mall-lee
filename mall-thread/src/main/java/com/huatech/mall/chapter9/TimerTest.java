package com.huatech.mall.chapter9;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author like
 * @date 2021-01-30 5:48 下午
 **/
public class TimerTest {
    public static void main(String[] args) {

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("======="+System.currentTimeMillis());
            }
        };
        timer.schedule(timerTask,1000,1000);


    }
}