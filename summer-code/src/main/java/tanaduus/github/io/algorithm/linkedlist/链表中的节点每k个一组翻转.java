package tanaduus.github.io.algorithm.linkedlist;

/**
 * @author 夏冬
 * @date 2022/6/15
 */
public class 链表中的节点每k个一组翻转 {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        int count = 1;
        ListNode resultHead = null;
        ListNode resultTair = null;

        ListNode tempHead = null;
        ListNode tempTair = null;

        while (head != null) {
            ListNode next = head.next;

            if (count == 1) {
                tempHead = head;
                tempTair = head;
            }

            if (count == k) {

                //执行k个反转
                ListNode childHead = reverseK(tempHead, k);

                if (resultHead == null) {
                    resultHead = childHead;
                    resultTair = tempTair;
                } else {

                    resultTair.next = childHead;
                    resultTair = tempTair;
                }

                //计数器需要重置
                count = 0;
            }

            count++;
            head = next;
        }

        if (count > 1) {
            //说明有不足k个的未反转元素，直接进行尾部插入
            if (resultHead == null) {
                resultHead = tempHead;
            } else {
                resultTair.next = tempHead;
            }
        }

        return resultHead;
    }

    private ListNode reverseK(ListNode head, int k) {
        ListNode newHead = null;

        for (int i = 1; i <= k; i++) {
            ListNode next = head.next;

            head.next = newHead;
            newHead = head;

            head = next;
        }

        return newHead;
    }

    /*
     方法二：

     和方法一一样将链表分成每段长度为k的子链表，将每个链表存入栈中，
     当栈中有k个元素即可一一取出，之后按取出的顺序重组链表就是这一段中翻转的链表，
     要注意的是处理尾部不满长度为k的链表块时直接取栈底的元素做为最后一段即可(只要暂存stack的底)。

     比较消耗空间，此处不写了
     */

}
