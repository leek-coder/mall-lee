package com.huatech.mall.link;

/**
 * @author like
 * @date 2021-01-23 11:15 上午
 **/
public abstract class AbstractList0<E> implements List0<E> {

    /**
     * 元素的数量
     */
    protected int size;

    /**
     * 元素的数量
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     *
     * @param element
     * @return
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element) == -1;
    }

    /**
     * 添加元素到尾部
     *
     * @param element
     */
    @Override
    public void add(E element) {
        add(size, element);
    }


    /**
     * 校验范围
     *
     * @param index
     */
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    protected void rangeCheckForAdd(int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

}