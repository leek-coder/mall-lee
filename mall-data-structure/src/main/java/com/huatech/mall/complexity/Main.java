package com.huatech.mall.complexity;

/**
 * 菲波拉契数
 * 0 1 1 2 3 5 8 13 21 34 55.....
 *
 * @author like
 * @date 2021-01-22 11:11 上午
 **/
public class Main {

    /**
     * 第一种方式
     *
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 第二种方式
     *
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    public static void main(String[] args) {

        int n  = 64;
        TimeTools.check("fib1", new TimeTools.Task() {
            @Override
            public void execute() {
                System.out.println(fib1(n));
            }
        });
        TimeTools.check("fib2", new TimeTools.Task() {
            @Override
            public void execute() {
                System.out.println(fib2(n));
            }
        });
    }
}