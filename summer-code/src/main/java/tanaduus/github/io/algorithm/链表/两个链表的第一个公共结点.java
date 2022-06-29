package tanaduus.github.io.algorithm.链表;

/**
 * @author 夏冬
 * @date 2022/6/21
 */
public class 两个链表的第一个公共结点 {

    /**
     * 双指针交替迭代，第一次相遇时就是第一个公共点
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode a = pHead1;
        ListNode b = pHead2;

        while (a != b) {

            if (a == null) {
                a = pHead2;
            } else {
                a = a.next;
            }

            if (b == null) {
                b = pHead1;
            } else {
                b = b.next;
            }
        }

        return a;
    }
}
