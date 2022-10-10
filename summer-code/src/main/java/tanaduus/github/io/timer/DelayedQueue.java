package tanaduus.github.io.timer;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author 夏加龙
 * @date 2022/10/07
 */
public class DelayedQueue<T extends DelayedTask> {

    private final PriorityQueue<T> priorityQueue;

    public DelayedQueue() {
        this.priorityQueue = new PriorityQueue<>();
    }

    public void offer(T t) {
        this.priorityQueue.offer(t);
    }

    public T poll() throws InterruptedException {
        while (true) {

            T first = this.priorityQueue.peek();
            if (first == null) {
                return null;//引入同步器做线程挂起
            }

            if (System.currentTimeMillis() >= first.getExecuteTime()) {

                return priorityQueue.poll();

            } else {
                TimeUnit.MILLISECONDS.sleep(first.getExecuteTime() - System.currentTimeMillis());
            }
        }
    }

}
