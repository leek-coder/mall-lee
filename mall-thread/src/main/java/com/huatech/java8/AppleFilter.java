package com.huatech.java8;

/**
 * @author like
 * @date 2021-01-31 12:15 下午
 **/
@FunctionalInterface
public interface AppleFilter {
    /**
     * 苹果过滤
     *
     * @param apple
     * @return
     */
    boolean filter(Apple apple);
}