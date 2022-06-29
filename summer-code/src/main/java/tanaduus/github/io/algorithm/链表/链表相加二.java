package tanaduus.github.io.algorithm.链表;

/**
 * 链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0
 *
 * @author 夏冬
 * @date 2022/6/21
 */
public class 链表相加二 {

    /**
     * 因为数字存储顺序是高位到低位，所以第一步反转链表
     * <p>
     * 第二位逐位相加，注意进位即可
     */
    public ListNode addInList1(ListNode head1, ListNode head2) {

        ListNode first = reverse(head1);
        ListNode second = reverse(head2);

        ListNode result = null;

        int up = 0;
        while (first != null || second != null) {

            int sum = (first != null ? first.val : 0) + (second != null ? second.val : 0) + up;
            if (sum >= 10) {
                sum = sum % 10;
                up = 1;
            } else {
                up = 0;
            }

            //头插入
            ListNode cur = new ListNode(sum);
            if (result == null) {
                result = cur;
            } else {
                cur.next = result;
                result = cur;
            }

            if (first != null) {
                first = first.next;
            }

            if (second != null) {
                second = second.next;
            }
        }

        if (up == 1) {
            //头插入
            ListNode cur = new ListNode(1);
            cur.next = result;
            result = cur;
        }

        return result;
    }

    private ListNode reverse(ListNode head) {

        ListNode newHead = null;

        while (head != null) {
            ListNode next = head.next;

            if (newHead == null) {
                head.next = null;
                newHead = head;
            } else {

                head.next = newHead;
                newHead = head;
            }

            head = next;
        }

        return newHead;
    }
}
