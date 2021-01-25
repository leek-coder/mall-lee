package com.huatech.mall.tree;

/**
 * @author like
 * @date 2021-01-25 8:40 上午
 **/
public class BinarySearchTree1<E extends  Comparable<E>> {

    /**
     * 数量
     */
    private int size;

    /**
     * 根节点
     */
    private Node<E> root;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    public void add(E element) {
        checkElement(element);
        //添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        //添加的不是第一个节点
        //找到父节点
        Node<E> parent = null;
        Node<E> node = root;
        int compare = 0;
        while (node != null) {
            compare = compare(element, root.element);
            parent = node;
            if (compare > 0) {
                node = node.right;
            } else if (compare < 0) {
                node = node.left;
            } else {
                //相等
                return;
            }
        }
        //看看插入父节点的哪个位置
        Node<E> nNode = new Node<>(element, parent);
        if (compare > 0) {
            parent.right = nNode;
        } else {
            parent.left = nNode;
        }
        size++;


    }

    public void remove(E element) {

    }

    public boolean contains(E element) {
        return false;
    }

    /**
     * 返回值等于0  e1==e2  返回值大于0:e1>e2  返回值小于0:e1<e2
     *
     * @param e1
     * @param e2
     * @return
     */
    private int compare(E e1, E e2) {
        return e1.compareTo(e2);
    }

    private void checkElement(E element) {
        if (null == element) {
            throw new IllegalArgumentException("element must not be null!");
        }
    }

    /**
     * 一个node就是一个节点
     *
     * @param <E>
     */
    private static class Node<E> {
        /**
         * 元素
         */
        E element;
        /**
         * 子节点
         */
        Node<E> left;
        /**
         * 右节点
         */
        Node<E> right;
        /**
         * 父节点
         */
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }
}