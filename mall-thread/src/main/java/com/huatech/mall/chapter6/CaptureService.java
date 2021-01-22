package com.huatech.mall.chapter6;

import java.util.*;

/**
 * @author like
 * @date 2021-01-19 10:16 上午
 * 模拟数据采集
 **/
public class CaptureService {

    final static private LinkedList<Control> CONTROLS = new LinkedList<>();
    private final static int MAX_WORKER = 5;

    public static void main(String[] args) {
        List<Thread> worker = new ArrayList<>();
        Arrays.asList("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10").stream().map(CaptureService::createCaptureThread)
                .forEach(t -> {
                    t.start();
                    worker.add(t);
                });

        worker.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Optional.of("All of capture work finished").ifPresent(System.out::println);


    }

    private static Thread createCaptureThread(String name) {
        return new Thread(() -> {
            Optional.of("The worker [ " + Thread.currentThread().getName() + "] begin capture data").ifPresent(System.out::println);
            synchronized (CONTROLS) {
                while (CONTROLS.size() > MAX_WORKER) {
                    try {
                        CONTROLS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                CONTROLS.addLast(new Control());
            }

            try {
                Optional.of("The worker [ " + Thread.currentThread().getName() + "] working  =====").ifPresent(System.out::println);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Optional.of("The worker [ " + Thread.currentThread().getName() + "] end capture data").ifPresent(System.out::println);
            synchronized (CONTROLS) {
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }
        }, name);
    }
    private static class Control {

    }
}

