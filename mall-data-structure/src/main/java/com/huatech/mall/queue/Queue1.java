package com.huatech.mall.queue;

import com.huatech.mall.link.LinkedList2;
import com.huatech.mall.link.List0;

/**
 * @author like
 * @date 2021-01-24 6:07 下午
 **/
public class Queue1<E> {


    private List0<E> list = new LinkedList2<>();

    /**
     * 元素的数量
     *
     * @return
     */
    public int size() {

        return list.size();
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }


    /**
     * 入队
     *
     * @param element
     */
    public void enQueue(E element) {
        list.add(element);
    }

    /**
     * 出队
     *
     * @return
     */
    public E deQueue() {
        return list.remove(0);
    }

    /**
     * 获取队列的头元素
     *
     * @return
     */
    public E front() {
        return list.get(0);
    }

    /**
     * 清空队列
     */
    public void clear() {
        list.clear();
    }
}