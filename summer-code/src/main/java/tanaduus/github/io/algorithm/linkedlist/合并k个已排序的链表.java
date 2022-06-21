package tanaduus.github.io.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author 夏冬
 * @date 2022/6/16
 */
public class 合并k个已排序的链表 {

    /**
     * 方法一
     * <p>
     * 全部转存到一个数组，进行排序重构
     */
    public ListNode mergeKLists1(ArrayList<ListNode> lists) {
        //略
        return null;
    }

    /**
     * 方法二
     * <p>
     * 每两个一组，然后就成了"合并两个排序的链表"问题。
     * 递归重复这一过程
     * <p>
     * 不知道为什么这个方式耗时很高
     */
    public ListNode mergeKLists2(ArrayList<ListNode> lists) {

        if (lists == null || lists.isEmpty()) {
            return null;
        }

        if (lists.size() == 1) {
            return lists.get(0);
        }

        //从尾部开始一直进行"合并两个排序的链表"
        while (lists.size() > 1) {
            //倒数第一个
            ListNode tair = lists.get(lists.size() - 1);
            //倒数第二个
            ListNode tair2 = lists.get(lists.size() - 2);

            //尾删除，防止数组重新移动
            lists.remove(lists.size() - 1);
            lists.remove(lists.size() - 1);

            ListNode newOne = merge2Lists(tair, tair2);
            if (newOne != null) {
                lists.add(newOne);
            }
        }

        return lists.get(0);
    }

    private ListNode merge2Lists(ListNode list1, ListNode list2) {

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

    /**
     * 方法三
     * <p>
     * 所有链表加入优先级队列，取出堆顶链表的头，放入结果链表；
     * 将next放回到堆，完成重新"优先级选举"
     * 重复上述动作
     */
    public ListNode mergeKLists3(ArrayList<ListNode> lists) {

        if (lists == null || lists.isEmpty()) {
            return null;
        }

        if (lists.size() == 1) {
            return lists.get(0);
        }

        ListNode head = null;
        ListNode tair = null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        //全部进入优先级队列
        if (lists.size() > 1) {

            Iterator<ListNode> iterator = lists.iterator();
            while (iterator.hasNext()) {
                ListNode listNode = iterator.next();
                if (listNode == null) {
                    iterator.remove();
                    continue;
                }

                priorityQueue.add(listNode);
            }
        }

        //每次从堆头拿出一个，然后放入一个next到堆里
        while (priorityQueue.size() > 0) {
            ListNode top = priorityQueue.poll();
            if (head == null) {
                head = top;
                tair = top;
            } else {
                tair.next = top;
                tair = top;
            }

            if (top.next != null) {
                priorityQueue.add(top.next);
            }
        }

        return head;
    }
}
