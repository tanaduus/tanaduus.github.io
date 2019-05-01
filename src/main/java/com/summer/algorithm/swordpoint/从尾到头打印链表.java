package com.summer.algorithm.swordpoint;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
 * 显然默认是单链表，传入的为链表头节点
 */
public class 从尾到头打印链表 {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归实现
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}
