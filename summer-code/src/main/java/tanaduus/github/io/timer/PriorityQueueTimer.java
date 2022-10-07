package tanaduus.github.io.timer;

import lombok.Builder;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/**
 * 一个基于优先级队列实现的单线程延迟队列
 *
 * @author 夏加龙
 * @date 2022/10/7
 */
public class PriorityQueueTimer {

    @Data
    @Builder
    public static class Task implements Comparable<Task> {

        //毫秒时间戳
        long executeTime;

        String value;

        @Override
        public int compareTo(Task obj) {
            return executeTime - obj.executeTime < 0L ? -1 : 1;
        }
    }

    static PriorityQueue<Task> priorityQueue = new PriorityQueue<>();


    public static void main(String[] args) throws InterruptedException {

        long cur = System.currentTimeMillis();

        priorityQueue.offer(Task.builder().executeTime(cur + 5 * 1000).value("我5秒后执行").build());
        priorityQueue.offer(Task.builder().executeTime(cur + 10 * 1000).value("我10秒后执行").build());
        priorityQueue.offer(Task.builder().executeTime(cur + 15 * 1000).value("我15秒后执行").build());

        while (true) {

            Task firstTask = priorityQueue.peek();
            if (firstTask == null) {
                return;
            }

            if (System.currentTimeMillis() >= firstTask.executeTime) {

                priorityQueue.poll();
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " : " + firstTask.value);

            } else {
                TimeUnit.MILLISECONDS.sleep(firstTask.executeTime - System.currentTimeMillis());
            }
        }
    }
}
