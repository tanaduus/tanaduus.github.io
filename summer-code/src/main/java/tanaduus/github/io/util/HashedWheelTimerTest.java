package tanaduus.github.io.util;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author 夏冬
 * @date 2021/5/17
 */
public class HashedWheelTimerTest {

    public static void main(String[] args) {
//        test1();

        test2();
    }

    private static void test1() {

        /*
            1、创建512个轮
            2、以worker构造一个thread对象
         */
        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer();

        /*
            1、初次调用时，会启动thread
            2、包装成HashedWheelTimeout扔到队列中
            3、已启动的thread里面，会执行worker的run方法，时间论式渐进消费（获取当前时间节点的bucket，依次执行里面的task）
         */
        hashedWheelTimer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("3秒后的我");
            }
        }, 3L, TimeUnit.SECONDS);
    }

    private static void test2() {
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("success");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }).start();
        }
    }

}
