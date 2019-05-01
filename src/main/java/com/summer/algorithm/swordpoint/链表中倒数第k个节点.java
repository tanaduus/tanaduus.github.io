package com.summer.algorithm.swordpoint;

import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 方法一：利用栈的特性
 * 方法二：0位置指针和k-1位置指针同时后移。较后面的指针触底时，前一个指针指向的就是倒数第k位
 */
public class 链表中倒数第k个节点 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法一：利用栈的特性
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode result = null;
        Stack<ListNode> stack = new Stack<ListNode>();
        pushToStack(stack,head);
        for(int i=0;i<k;i++){
            if(!stack.empty()) {
                if (i == (k - 1)) {
                    result = stack.peek();
                } else {
                    stack.pop();
                }
            }else{
                return null;
            }
        }
        return result;
    }

    public void pushToStack(Stack stack,ListNode node){
        stack.push(node);
        ListNode next = node.next;
        if(next!=null){
            pushToStack(stack,next);
        }
    }
}
