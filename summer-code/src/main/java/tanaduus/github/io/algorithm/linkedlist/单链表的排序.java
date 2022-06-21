package tanaduus.github.io.algorithm.linkedlist;

/**
 * @author 夏冬
 * @date 2022/6/21
 */
public class 单链表的排序 {

    public ListNode sortInList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        //快慢指针找中点
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode right = slow.next;
        slow.next = null;//断开

        ListNode left = sortInList(head);
        right = sortInList(right);

        //合并排序链表
        ListNode lhead = new ListNode(-1);
        ListNode res = lhead;
        //归并排序
        while(left != null && right != null){
            if(left.val < right.val){
                lhead.next = left;
                left = left.next;
            }else{
                lhead.next = right;
                right = right.next;
            }
            lhead = lhead.next;
        }
        //判断左右链表是否为空
        lhead.next = left!=null?left:right;
        return res.next;
    }
}
