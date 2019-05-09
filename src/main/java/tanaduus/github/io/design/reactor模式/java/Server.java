package tanaduus.github.io.design.reactor模式.java;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    private Selector selector = new Selector();
    private Dispatcher eventLooper = new Dispatcher(selector);

    private void start() {
        //处理器不仅仅只能在此注册。也可以根据客户端的具体情况，动态的注册专属于某一连接的处理器。
        eventLooper.registEventHandler(EventType.READ, new ReadEventHandler(selector));
        eventLooper.registEventHandler(EventType.WRITE, new WriteEventHandler(selector));
        eventLooper.handleEvents();
    }

    public static void main(String[] args) throws InterruptedException {
        Server server = new Server();

        ExecutorService executorService = new ThreadPoolExecutor(3, 3, 0,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new ThreadFactoryBuilder().setNameFormat("test-%d").build());


        //服务器启动
        executorService.submit(server::start);

        //创造读事件
        executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                Event event = new Event();
                event.setType(EventType.READ);
                event.setBuffer("read"+i);
                server.selector.addEvent(event);
            }
        });

        TimeUnit.SECONDS.sleep(3);

        //创造写事件
        executorService.submit(() -> {
            for (int i = 0; i < 5; i++) {
                Event event = new Event();
                event.setType(EventType.WRITE);
                event.setBuffer("write"+i);
                server.selector.addEvent(event);
            }
        });

    }
}