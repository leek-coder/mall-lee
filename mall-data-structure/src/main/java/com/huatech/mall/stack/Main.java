package com.huatech.mall.stack;


/**
 * 栈
 *
 * @author like
 * @date 2021-01-24 4:50 下午
 **/
public class Main {

    public static void main(String[] args) {

        Stack1<Integer> stack = new Stack1<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}