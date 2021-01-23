package com.huatech.mall.link.leetcode;

/**
 * @author like
 * @date 2021-01-23 9:46 下午
 **/
public class _141_环型链表 {

    /**
     * 判断一个链表是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}