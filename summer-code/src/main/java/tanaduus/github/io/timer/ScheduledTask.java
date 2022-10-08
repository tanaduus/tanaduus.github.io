package tanaduus.github.io.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 基于{@link ScheduledThreadPoolExecutor}实现的定时任务
 *
 * @author 夏加龙
 * @date 2022/10/7
 */
public class ScheduledTask {

    /**
     * 原理：
     * 1.构造器的同步延迟队列DelayedWorkQueue（小顶堆）
     * 2.发布任务时，将其包装成一个DelayedWorkQueue的元素RunnableScheduledFuture
     * 3.线程池开始消费，从DelayedWorkQueue拉取任务
     * 4.DelayedWorkQueue的poll方法会对顶部任务判断时间后返回或挂起指定时间
     * <p>
     * todo 如何实现周期性定时任务呢，简单来说就是任务执行完之后，修改一下延迟时间，重新丢进去任务池
     */
    public static void main(String[] args) {

        ScheduledThreadPoolExecutor executorService = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(4);

        executorService.schedule(() -> System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " : 我5秒后执行"),
                5,
                TimeUnit.SECONDS);

        executorService.schedule(() -> System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " : 我10秒后执行"),
                10,
                TimeUnit.SECONDS);

        executorService.schedule(() -> System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " : 我15秒后执行"),
                15,
                TimeUnit.SECONDS);

        executorService.shutdown();
    }
}
