package tanaduus.github.io.algorithm.linkedlist;

/**
 * @author 夏冬
 * @date 2022/6/20
 */
public class 删除链表的倒数第n个节点 {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        //创建一个新头
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //找到倒数第n+1个
        ListNode nth = findNthFromEnd(dummy, n+1);

        //删除该节点的下一个节点
        if (nth == null) {
            return head;
        }

        nth.next = nth.next.next;

        //不返回head，防止head也被删除
        return dummy.next;
    }

    private ListNode findNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 1; i <= n - 1; i++) {

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
}
