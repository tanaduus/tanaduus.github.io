package tanaduus.github.io.algorithm.随机剑指;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class 合并两个排序链表 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = list1;
        ListNode preNode = null;
        ListNode nextNode = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                preNode = list1;
                list1 = list1.next;
                if (list1 == null) {
                    preNode.next = list2;
                }
            } else {
                preNode.next = list2;
                nextNode = list2.next;
                list2.next = list1;
                list2 = nextNode;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = c;
        c.next = e;
        b.next = d;
        d.next = f;

        Merge(a, b);
        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }
}
