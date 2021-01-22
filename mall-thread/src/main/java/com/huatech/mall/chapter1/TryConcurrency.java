package com.huatech.mall.chapter1;

/**
 * @author like
 * @date 2021-01-17 9:51 上午
 **/
public class TryConcurrency {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());
        new Thread("Read Thread") {
            @Override
            public void run() {
                readFromDataBase();
            }
        }.start();
        //start方法是立刻返回的

        new Thread("WRITE Thread") {
            @Override
            public void run() {
                writeDataToFile();
            }
        }.start();


    }

    /**
     * 从数据库里读数据
     */
    private static void readFromDataBase() {
        try {
            printLn("Begin read data from db");
            Thread.sleep(1000 * 10L);
            printLn("Read data done and start");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printLn("The data handle finish and success");
    }


    private static void writeDataToFile() {

        try {
            printLn("Begin write data to file");
            Thread.sleep(2000 * 10L);
            printLn("write data done and start");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printLn("The data handle finish and success");
    }

    private static void printLn(String message) {
        System.out.println(message);
    }
}