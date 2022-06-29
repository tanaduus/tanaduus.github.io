package tanaduus.github.io.algorithm.链表;

/**
 * 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 * 例如：
 * 给出的链表为1→2→3→3→4→4→5, 返回1→2→5.
 * 给出的链表为1→1→1→2→3, 返回2→3.
 *
 * @author 夏冬
 * @date 2022/6/22
 */
public class 删除有序链表中重复的元素2 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode nHead = new ListNode(0);
        nHead.next = head;

        ListNode pre = nHead;
        ListNode cur = head;

        boolean repeat = false;
        while (cur != null && cur.next != null) {

            while (cur.next != null && cur.val == cur.next.val) {
                repeat = true;
                cur = cur.next;
            }

            if (repeat) {
                pre.next = cur.next;
                pre = pre.next;
                cur = cur.next;

                repeat = false;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }

        return nHead.next;
    }

    public ListNode deleteDuplicates2 (ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode p=head;
        while(p!=null&&p.next!=null){
            if(p.val==p.next.val){
                while(p.next!=null&&p.val==p.next.val){
                    p=p.next;
                }
                pre.next=p.next;
                p=p.next;
            }
            else{
                pre=p;
                p=p.next;
            }
        }
        return dummy.next;
    }
}
