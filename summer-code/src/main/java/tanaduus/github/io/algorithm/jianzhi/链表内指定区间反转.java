package tanaduus.github.io.algorithm.jianzhi;

/**
 * @author 夏冬
 * @date 2022/6/15
 */
public class 链表内指定区间反转 {

    public static void main(String[] args) {

        ListNode a = new ListNode(3);
        ListNode b = new ListNode(5);
        a.next = b;

        链表内指定区间反转 链表内指定区间反转 = new 链表内指定区间反转();

        链表内指定区间反转.reverseBetween(a, 1, 1);
    }


    /**
     * 截取子链，反转后，重建原链表
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return null;
        }

        int index = 1;
        ListNode childHead = null;
        ListNode childHeadParent = null;
        ListNode childTail = null;
        ListNode childTailNext = null;

        ListNode temp = head;
        while (temp != null) {

            if (index == (m - 1)) {
                childHeadParent = temp;
            }

            if (index == m) {
                childHead = temp;
            }

            if (index == n) {
                childTail = temp;
            }

            if (index == (n + 1)) {
                childTailNext = temp;
                break;
            }

            index++;
            temp = temp.next;
        }

        //子链表反转
        reverse(childHead, n - m + 1);
        ListNode newChildHead = childTail;
        ListNode newChildTail = childHead;

        //重新回到组织
        if (childHeadParent != null) {

            childHeadParent.next = newChildHead;
        } else {
            head = newChildHead;
        }

        if (childTailNext != null) {
            newChildTail.next = childTailNext;
        }

        return head;
    }

    private void reverse(ListNode head, int count) {

        ListNode newListHead = null;
        int index = 1;
        while (head != null && index <= count) {
            ListNode current = head;
            head = head.next;
            index++;

            current.next = newListHead;
            newListHead = current;
        }
    }
}
