package tanaduus.github.io.algorithm.linkedlist;

import java.util.HashSet;

/**
 * @author 夏冬
 * @date 2022/6/16
 */
public class 判断链表中是否有环 {

    /**
     * 快慢指针法
     */
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (true) {

            fast = fast.next;
            if (fast == null) {
                return false;
            }

            slow = slow.next;
            if (slow == null) {
                return false;
            }

            slow = slow.next;
            if (slow == null) {
                return false;
            }

            if (fast == slow) {
                return true;
            }
        }
    }

    /**
     * hash法
     * <p>
     * 迭代的过程中发现出现重复值，则成环
     */
    public boolean hasCycle2(ListNode head) {

        if (head == null) {
            return false;
        }

        HashSet<ListNode> set = new HashSet<>();

        while (head!=null) {

            if(set.contains(head)) {
                return true;
            }

            set.add(head);

            head = head.next;
        }

        return false;
    }
}
