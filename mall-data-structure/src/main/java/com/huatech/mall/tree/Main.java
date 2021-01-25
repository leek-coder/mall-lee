package com.huatech.mall.tree;

import com.huatech.mall.tree.printer.BinaryTrees;
import com.sun.source.tree.BinaryTree;

import java.util.Comparator;

/**
 * @author like
 * @date 2021-01-25 8:40 上午
 **/
public class Main {

    private static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer e1, Integer e2) {
            return e1 - e2;
        }
    }

    public static void main(String[] args) {

        test2();

    }

    private static void test1() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new IntegerComparator());
        bst.add(7);
        bst.add(4);
        bst.add(9);
        bst.add(2);
        bst.add(5);
        bst.add(8);
        bst.add(11);
        bst.add(3);
        bst.add(12);
        bst.add(1);
        BinaryTrees.println(bst);
        String string = BinaryTrees.printString(bst);
        System.out.println(string);
    }

    private static void test2() {
        BinarySearchTree<Person> bst = new BinarySearchTree<>();
        bst.add(new Person(10));
        bst.add(new Person(11));
        bst.add(new Person(8));
        BinaryTrees.println(bst);
    }
}