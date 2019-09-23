package tanaduus.github.io.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String[] args) throws InterruptedException {

        test2();
    }

    static void test2() throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("start "+Thread.currentThread().isInterrupted());

            LockSupport.park();

            System.out.println("end "+Thread.currentThread().isInterrupted());
        });

        t1.start();

        TimeUnit.SECONDS.sleep(3);

        t1.interrupt();
//        LockSupport.unpark(t1);
    }

    static void test1(){
        Thread t2 = new Thread(()->{
            System.out.println("start "+Thread.currentThread().isInterrupted());

            LockSupport.unpark(Thread.currentThread());
            LockSupport.park();
            LockSupport.park();

            System.out.println("end "+Thread.currentThread().isInterrupted());
        });

        t2.start();
    }
}
