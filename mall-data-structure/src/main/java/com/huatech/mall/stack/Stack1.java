package com.huatech.mall.stack;

import com.huatech.mall.array.ArrayList0;
import com.huatech.mall.link.List0;

/**
 * @author like
 * @date 2021-01-24 5:08 下午
 **/
public class Stack1<E> {

    private List0<E> list = new ArrayList0<>();

    /**
     * 长度
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
     * 往栈顶添加元素
     *
     * @param element
     */
    public void push(E element) {
        list.add(element);
    }

    /**
     * 弹出栈顶元素
     *
     * @return
     */
    public E pop() {
        return list.remove(list.size() - 1);
    }

    /**
     * 弹出栈顶元素
     *
     * @return
     */
    public E top() {
        return list.get(list.size() - 1);
    }
}