package tanaduus.github.io.thread;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DeadlockTest {

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));

        threadPoolExecutor.submit(()->{
            synchronized (a) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {

                }
            }
        });

        threadPoolExecutor.submit(()->{
            synchronized (b) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {

                }
            }
        });
    }
}
