package com.huatech.mall.link.leetcode;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/comments/
 *
 * @author like
 * @date 2021-01-23 12:29 下午
 **/
public class _237_删除链表中的节点 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}


