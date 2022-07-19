package tanaduus.github.io.algorithm.堆栈队列;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 夏冬
 * @date 2022/7/13
 */
public class 最小K个数 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();

        if (input == null || input.length == 0 || k == 0) {
            return result;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1 - o2);
            }
        });

        for (int e : input) {

            if (priorityQueue.size() < k) {
                priorityQueue.offer(e);
            } else {
                Integer max = priorityQueue.peek();

                if (max > e) {
                    priorityQueue.poll();
                    priorityQueue.offer(e);
                }
            }
        }

        priorityQueue.forEach(e -> {
            result.add(e);
        });
        return result;
    }
}
