package com.huatech.mall.stack.leetcode;

import java.util.Stack;

/**
 * @author like
 * @date 2021-01-24 5:29 下午
 **/
public class _20有效的括号 {

    public static void main(String[] args) {

        System.out.println(isValid("[[](){}]"));
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                if (c == ')' && left != '(') {
                    return false;
                }
                if (c == '}' && left != '{') {
                    return false;
                }
                if (c == ']' && left != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}