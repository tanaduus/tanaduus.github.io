package com.summer.algorithm.swordpoint;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class 反转链表 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        ListNode result = null;

        ListNode pre = null;
        while (head != null) {
            result = head;
            ListNode next = null;

            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode head = ReverseList(a);
    }
}
