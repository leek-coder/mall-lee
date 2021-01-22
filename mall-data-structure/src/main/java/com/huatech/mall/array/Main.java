package com.huatech.mall.array;


/**
 * @author like
 * @date 2021-01-22 2:51 下午
 **/
public class Main {

    public static void main(String[] args) {

        ArrayList0<Integer> list0 = new ArrayList0<>();
        list0.add(1);
        list0.add(2);
        list0.add(3);
        list0.add(3);
        list0.set(1, 80);
        list0.add(5);
        list0.add(list0.size(), 10);

        System.out.println(list0);

        System.out.println(16 << 1);

    }
}