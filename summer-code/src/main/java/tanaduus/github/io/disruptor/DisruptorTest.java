package tanaduus.github.io.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.LockSupport;

/**
 * @author 夏加龙
 * @date 2022/9/27
 */
public class DisruptorTest {

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Disruptor<OrderEvent> disruptor = new Disruptor<>(
                OrderEvent::new,
                1024 * 1024,
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("D-POOL-" + (i++));
                        return thread;
                    }
                },
                ProducerType.SINGLE,
                new BlockingWaitStrategy()
        );
        disruptor.handleEventsWith(new OrderEventHandler(), new OrderEventHandler(), new OrderEventHandler());
        disruptor.start();

        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
        OrderEventProducer eventProducer = new OrderEventProducer(ringBuffer);


        for (int i = 0; i < 100; i++) {
            eventProducer.onData(UUID.randomUUID().toString());
        }

        LockSupport.park();

        // 创建一个线程池，模拟多个生产者
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);
//        for (int i = 0; i < 100; i++) {
//            fixedThreadPool.execute(() -> eventProducer.onData(UUID.randomUUID().toString()));
//        }
    }
}
