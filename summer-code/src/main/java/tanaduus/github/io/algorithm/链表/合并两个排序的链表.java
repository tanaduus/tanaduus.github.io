package tanaduus.github.io.algorithm.链表;

/**
 * @author 夏冬
 * @date 2022/6/15
 */
public class 合并两个排序的链表 {

    public ListNode Merge(ListNode list1, ListNode list2) {

        ListNode head = null;
        ListNode tair = head;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                if (head == null) {
                    head = list1;
                    tair = list1;
                } else {
                    tair.next = list1;
                    tair = list1;
                }

                list1 = list1.next;
            } else {
                if (head == null) {
                    head = list2;
                    tair = list2;
                } else {
                    tair.next = list2;
                    tair = list2;
                }

                list2 = list2.next;
            }
        }

        //合并未比较部分
        if (list1 != null) {
            if (head == null) {
                head = list1;
            } else {
                tair.next = list1;
            }
        }

        if (list2 != null) {
            if (head == null) {
                head = list2;
            } else {
                tair.next = list2;
            }
        }

        return head;
    }
}
