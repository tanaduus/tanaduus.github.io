package tanaduus.github.io.queue;

import java.util.PriorityQueue;

public class topK {

    static int k = 3;
    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) {

        offer(5);
        offer(9);
        offer(3);
        offer(1);
        offer(4);
        offer(7);
        offer(2);

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

    private static void offer(Integer i) {

        if (priorityQueue.size() < k) {
            priorityQueue.offer(i);
        } else {
            Integer peek = priorityQueue.peek();
            if (i > peek) {
                priorityQueue.poll();
                priorityQueue.offer(i);
            }
        }
    }
}
