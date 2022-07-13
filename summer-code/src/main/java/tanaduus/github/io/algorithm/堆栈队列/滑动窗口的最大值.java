package tanaduus.github.io.algorithm.堆栈队列;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 夏冬
 * @date 2022/7/12
 */
public class 滑动窗口的最大值 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> result = new ArrayList<>();

        if (num.length == 0 || size == 0) return result;

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < num.length; i++) {

            if (i < size - 1) {
                while (!deque.isEmpty() && num[deque.getLast()] < num[i]) {
                    deque.removeLast();
                }

                deque.addLast(i);
                continue;
            }

            if (!deque.isEmpty() && deque.getFirst() < i - size + 1) {//已失效
                deque.removeFirst();
            }

            while (!deque.isEmpty() && num[deque.getLast()] < num[i]) {
                deque.removeLast();
            }

            deque.addLast(i);

            result.add(deque.getFirst());
        }

        return result;
    }
}
