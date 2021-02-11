package com.huatech.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author like
 * @date 2021-01-31 11:56 上午
 **/
public class FilterApple {

    public static List<Apple> findGreenApple(List<Apple> apples) {
        List<Apple> filters = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getColor().equals("green")) {
                filters.add(apple);
            }
        }
        return filters;
    }

    public static List<Apple> findApples(List<Apple> apples, AppleFilter appleFilter) {
        List<Apple> filters = new ArrayList<>();
        for (Apple apple : apples) {
            if (appleFilter.filter(apple)) {
                filters.add(apple);
            }
        }
        return filters;
    }

    public static void main(String[] args) {

        List<Apple> green = Arrays.asList(new Apple("green", 10L), new Apple("red", 10L));
        List<Apple> filters = findApples(green, (apple) -> {
            return apple.getColor().equals("green");
        });
        System.out.println(filters);

        new Thread(()->{
            System.out.println("Thread-01");
        }).start();

    }
}