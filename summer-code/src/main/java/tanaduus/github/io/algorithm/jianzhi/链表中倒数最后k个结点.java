package tanaduus.github.io.algorithm.jianzhi;

/**
 * @author 夏冬
 * @date 2022/6/20
 */
public class 链表中倒数最后k个结点 {

    /**
     * 双指针同向不同起点移动
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {

        if (pHead == null) {
            return null;
        }

        if (k <= 0) {
            return null;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;

        for (int i = 1; i <= k - 1; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        if (fast == null) {
            return null;
        }


        while (fast.next != null) {

            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


    /**
     * 栈法
     */
    public ListNode FindKthToTail2(ListNode pHead, int k) {
        return null;
    }
}
