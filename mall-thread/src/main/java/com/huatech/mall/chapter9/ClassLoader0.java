package com.huatech.mall.chapter9;

/**
 * @author like
 * @date 2021-01-30 1:58 下午
 **/
public class ClassLoader0 {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        MyObject myObject1 = new MyObject();
        MyObject myObject2 = new MyObject();
        System.out.println(myObject.getClass() == myObject1.getClass());
    }

}

class MyObject {

}