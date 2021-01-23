package com.huatech.mall.link;

/**
 * @author like
 * @date 2021-01-23 10:55 上午
 **/
public class LinkedList0<E> extends AbstractList0<E> {

    private Node<E> first;

    /**
     * 清空链表
     */
    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    /**
     * 添加元素
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0) {
            first = new Node<>(element, first);
        } else {
            //获取上一个节点
            Node prev = node(index - 1);
            prev.next = new Node(element, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = null;
        if (index == 0) {
            node = first.next;
            first = node;
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = prev.next.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return -1;
    }


    /**
     * 根据索引查询node
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> node = first;
        builder.append("size=").append(size).append(",[");
        for (int i = 0; i < size; i++) {
            builder.append(node.element);
            if (i != size - 1) {
                builder.append(",");
            }
            node = node.next;
        }

        builder.append("]");
        return builder.toString();
    }

    /**
     * 内部类
     *
     * @param <E>
     */
    private static class Node<E> {

        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}