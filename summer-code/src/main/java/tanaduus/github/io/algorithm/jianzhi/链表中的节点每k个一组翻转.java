package tanaduus.github.io.algorithm.jianzhi;

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
}
