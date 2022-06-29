package tanaduus.github.io.algorithm.链表;

/**
 * @author 夏冬
 * @date 2022/6/20
 */
public class 链表中环的入口结点 {

    /**
     * 快慢指针法（精妙的一匹）
     * <p>
     * 快慢指针法求环入口：
     * <p>
     * 如下的环链，a表示入口前的长度，b表示环长度。
     * <p>
     * |-------- a -----------|----------|
     * |    b     |
     * |----------|
     * <p>
     * 用s表示慢指针所行进的距离，那么快指针行进的距离时2s
     * 当它们相遇时，一定有 s+Nb=2s, 即s=Nb（表示相遇时，慢指针行进的距离等于环长的整数倍）
     * <p>
     * 同时，慢指针到达环入口时，其行进距离公式=a+Mb
     * <p>
     * 那么当相遇时（s=Nb），慢指针只需要再走a步就一定能到达环入口（从头到环入口需要a步，从相遇点到入口也需要a步）。
     * <p>
     * 所以此时将快指针放到头部，并将其速度变成慢指针，让两个指针同时开始行进。当他们相遇时，一定是在环入口相遇，也一定是走了a步。
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null) {
            return null;
        }

        //1、先找出相遇点
        ListNode fast = pHead;
        ListNode slow = pHead;


        while (fast.next != null && slow.next.next != null) {

            fast = fast.next;
            slow = slow.next.next;

            if (fast == slow) {
                //2、相遇时，快指针回到head，两个指针同时以慢方式行进，直到相遇
                slow = pHead;

                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }

                return fast;
            }
        }

        return null;
    }

    /**
     * hash法，使用hashSet保存访问次数，首次重复访问的节点就是环入口
     */
    public ListNode EntryNodeOfLoop2(ListNode pHead) {

        return null;
    }
}
