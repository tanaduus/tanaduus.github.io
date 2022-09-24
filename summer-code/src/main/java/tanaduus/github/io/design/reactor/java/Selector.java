package tanaduus.github.io.design.reactor.java;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Selector {
    /**
     * 事件队列
     */
    private BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<Event>();

    BlockingQueue<Event> select() {
        while (eventQueue.isEmpty()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return eventQueue;
    }

    public void addEvent(Event e) {
        eventQueue.offer(e);
    }

}