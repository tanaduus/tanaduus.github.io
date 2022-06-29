package tanaduus.github.io.algorithm.链表;

import java.util.Stack;

public class 反转链表 {

    /**
     * 栈先进后出
     */
    public ListNode ReverseList1(ListNode head) {

        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        if (stack.isEmpty()) {
            return null;
        }

        ListNode result = stack.pop();
        ListNode temp = result;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }

        temp.next = null;
        return result;
    }

    /**
     * 双链表
     * <p>
     * 前一个链表的每一个取出来对一个新链表进行头插入
     */
    public ListNode ReverseList2(ListNode head) {

        ListNode result = null;

        while (head != null) {
            ListNode current = head;
            head = head.next;

            current.next = result;
            result = current;
        }

        return result;
    }

    /**
     * 递归
     */
    public ListNode ReverseList3(ListNode head) {

        return reverse(head);
    }

    /**
     * 反转链表函数
     * <p>
     * 输入老head
     * 输出新head
     *
     * @param head
     * @return new head
     */
    private ListNode reverse(ListNode head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode childListHead = reverse(head.next);
        ListNode childListTail = head.next;

        //head加入到childListTail之后，完成反转
        childListTail.next = head;
        head.next = null;

        return childListHead;
    }
}


