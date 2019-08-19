package tanaduus.github.io.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class threadFactoryBuilder {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(4, 4,
                0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(4),new ThreadFactoryBuilder().setNameFormat("test-%d").build());


        Object o = new Object();

        Future<String> submit = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "success";
        });

        submit.cancel(true);

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            synchronized (o){
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            synchronized (o){
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
                synchronized (o) {
                    o.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

//        executorService.shutdown();
//        while (!executorService.isTerminated()) {
//            System.out.println("stopping");
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("end");

    }
}
