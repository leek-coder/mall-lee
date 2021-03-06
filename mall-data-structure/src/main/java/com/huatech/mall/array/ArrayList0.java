package com.huatech.mall.array;

import com.huatech.mall.link.AbstractList0;

/**
 * @author like
 * @date 2021-01-22 2:54 下午
 **/
public class ArrayList0<E> extends AbstractList0<E> {


    /**
     * 所有的元素
     */
    private E[] elements;

    /**
     * 默认长度
     */
    private static final int DEFAULT_CAPACITY = 10;


    public ArrayList0(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    public ArrayList0() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 清除所有元素
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }


    /**
     * 获取index位置的元素
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置index位置的元素
     *
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 在index位置插入一个元素
     * 1 2 3 4 5
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {

        rangeCheckForAdd(index);
        //size和elements的length是不一样的
        ensureCapacity(size + 1);
        for (int i = size; index < i; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 删除index位置的元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        // 1 2 3 4
        for (int i = index; i <= size; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return old;
    }

    /**
     * 查看元素的索引
     *
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }


    /**
     * 保证要有capacity的容量
     * 扩容
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }
        //右移1除以2
        //左移1是乘以2
        int newCapacity = oldCapacity + oldCapacity >> 1;
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        //elements指向新的数组
        elements = newElements;
    }


    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("size=").append(size).append(",[");
        for (int i = 0; i < size; i++) {
            builder.append(elements[i]);
            if (i != size - 1) {
                builder.append(",");
            }
        }

        builder.append("]");
        return builder.toString();
    }


}