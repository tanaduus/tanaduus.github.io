package tanaduus.github.io.algorithm.linkedlist;

/**
 * @author 夏冬
 * @date 2022/6/21
 */
public class 链表的奇偶重排 {

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode secondList = head.next;

        ListNode fast = secondList;
        ListNode slow = head;

        while (fast!=null && fast.next!=null) {

            slow.next = slow.next.next;
            slow = slow.next;

            fast.next = fast.next.next;
            fast = fast.next;
        }

        slow.next = secondList;

        return head;
    }
}
