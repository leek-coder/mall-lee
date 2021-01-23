package com.huatech.mall.link;


/**
 * @author like
 * @date 2021-01-23 10:48 上午
 **/
public class Main {
    public static void main(String[] args) {

        List0<Integer> list = new LinkedList0<>();
        list.add(10);
        list.add(2);
        list.add(1,200);
        list.add(0,34);
        list.remove(1);
        list.clear();
        System.out.println(list);
    }
}