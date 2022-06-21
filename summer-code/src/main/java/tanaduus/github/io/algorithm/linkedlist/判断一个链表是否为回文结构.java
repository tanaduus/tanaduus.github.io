package tanaduus.github.io.algorithm.linkedlist;

/**
 * @author 夏冬
 * @date 2022/6/21
 */
public class 判断一个链表是否为回文结构 {

    /**
     * 快慢指针求中点，然后后面反转。再之后进行比较
     */
    public boolean isPail(ListNode head) {

        if (head == null) {
            return false;
        }

        if (head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //奇数个，slow是中点
        if (fast != null) {
            slow = slow.next;
        }
        //偶数个，slow是右边头

        ListNode newRight = reverse(slow);

        while (newRight != null) {
            if (head.val != newRight.val) {
                return false;
            }

            head = head.next;
            newRight = newRight.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
