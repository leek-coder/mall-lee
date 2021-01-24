package com.huatech.mall.link;

/**
 * 双向链表
 *
 * @author like
 * @date 2021-01-23 10:55 上午
 **/
public class LinkedList2<E> extends AbstractList0<E> {

    private Node<E> first;
    private Node<E> last;

    /**
     * 清空链表
     */
    @Override
    public void clear() {
        first = null;
        last = null;
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
        if (index == size) {
            //之前的last
            Node<E> node = last;
            last = new Node<>(node, element, null);
            node.next = last;
        } else {
            //获取要插入位置的node节点
            Node next = node(index);
            Node prev = next.prev;
            Node newNode = new Node(prev, element, next);
            next.prev = newNode;
            //index==0
            if (prev == null) {
                first = newNode;
            } else {
                prev.next = newNode;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        Node<E> node = node(index);
        //取得节点的直接前驱
        Node<E> prev = node.prev;
        //取得节点的直接后继
        Node<E> next = node.next;
        //index==0
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }
        //index==size-1
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
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
        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }

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
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }
}