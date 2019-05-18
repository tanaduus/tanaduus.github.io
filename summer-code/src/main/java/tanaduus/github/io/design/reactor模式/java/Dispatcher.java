package tanaduus.github.io.design.reactor模式.java;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class Dispatcher {
    /**
     * 通过ConcurrentHashMap来维护不同事件处理器
     */
    private Map<EventType, EventHandler> eventHandlerMap = new ConcurrentHashMap<EventType, EventHandler>();

    /**
     * 本例只维护一个selector负责事件选择，netty为了保证性能实现了多个selector来保证循环处理性能，不同事件加入不同的selector的事件缓冲队列
     */
    private Selector selector;

    Dispatcher(Selector selector) {
        this.selector = selector;
    }

    /**
     * 在Dispatcher中注册eventHandler
     */
    public void registEventHandler(EventType eventType, EventHandler eventHandler) {
        eventHandlerMap.put(eventType, eventHandler);
    }

    public void removeEventHandler(EventType eventType) {
        eventHandlerMap.remove(eventType);
    }

    public void handleEvents() {
        while (true) {
            //阻塞在select轮询上
            BlockingQueue<Event> events = selector.select();

            Iterator<Event> iterator = events.iterator();

            while(iterator.hasNext()){
                Event event = iterator.next();

                //分发调用事件处理器
                dispatch(event);

                //处理完事件后，从集合中删除
                iterator.remove();
            }
        }
    }

    /**
     * 此例只是实现了简单的事件分发给相应的处理器处理，例子中的处理器都是同步，在reactor模式的典型实现NIO中都是在handle异步处理，来保证非阻塞
     */
    private void dispatch(Event event) {
        EventHandler eventHandler = eventHandlerMap.get(event.getType());
        eventHandler.handle(event);
    }
}