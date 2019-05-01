package com.summer.thread;

import java.util.concurrent.*;

public class threadFactoryBuilder {

    public static void main(String[] args) {
//        ExecutorService executorService = new ThreadPoolExecutor(2, 2,
//                0, TimeUnit.SECONDS,
//                new LinkedBlockingDeque<>(4),new ThreadFactoryBuilder().setNameFormat("test-%d").build());

        //guava实现了format功能,直接实现ThreadFactory未能实现
        ExecutorService executorService = new ThreadPoolExecutor(2, 2,
                0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r, "xia");
                return t;
            }
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

//        executorService.submit(() -> {
//            System.out.println(Thread.currentThread().getName());
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        executorService.submit(() -> {
//            System.out.println(Thread.currentThread().getName());
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        executorService.submit(() -> {
//            System.out.println(Thread.currentThread().getName());
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            System.out.println("stopping");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end");

    }
}
