package tanaduus.github.io.algorithm.链表;

/**
 * @author 夏冬
 * @date 2022/6/21
 */
public class 删除有序链表中重复的元素1 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;

        while (temp != null && temp.next != null) {

            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;

            } else {
                temp = temp.next;
            }
        }

        return head;
    }
}
