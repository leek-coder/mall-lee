package com.huatech.mall.link.leetcode;

/**
 * @author like
 * @date 2021-01-23 12:47 下午
 **/
public class _反转一个链表 {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        System.out.println("aaaaa");
        ListNode newHeader = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHeader;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        ListNode listNode = reverseList(node1);
        System.out.println(listNode.val);

    }
}