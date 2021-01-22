package com.huatech.mall.chapter4;

/**
 * @author like
 * @date 2021-01-18 11:04 上午
 **/
public class TestTicketBankRunnable {
    public static void main(String[] args) {

        TicketBankRunnable ticketBank = new TicketBankRunnable();
        Thread t1 = new Thread(ticketBank,"t1");
        Thread t2 = new Thread(ticketBank,"t2");
        Thread t3 = new Thread(ticketBank,"t3");
        t1.start();
        t2.start();
        t3.start();
    }
}