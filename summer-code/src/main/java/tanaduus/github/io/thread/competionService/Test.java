package tanaduus.github.io.thread.competionService;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    private static AtomicInteger count = new AtomicInteger(1);

    private ThreadPoolExecutor defaultPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                1,
                5L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1),
                new ThreadFactoryBuilder().setNameFormat("test-%d").build());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.setRejectedExecutionHandler((r, executor) -> {
            try {
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        });
        return threadPoolExecutor;
    }

    public static void main(String[] args) {
        Test test = new Test();
        final ThreadPoolExecutor threadPoolExecutor = test.defaultPool();

        BlockingQueue<Future<Integer>> competionQueue = new LinkedBlockingQueue<>();
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(threadPoolExecutor, competionQueue);

        ConsumerThread consumerThread = new ConsumerThread(Thread.currentThread(), competionQueue);
        consumerThread.start();

        for (int i = 0; i < 100; i++) {

            completionService.submit(() -> {
                Thread.sleep(5000);
                return count.incrementAndGet();
            });
        }
    }

    static class ConsumerThread extends Thread {

        private Thread mainThread;

        private BlockingQueue<Future<Integer>> competionQueue;

        ConsumerThread(Thread mainThread, BlockingQueue<Future<Integer>> competionQueue) {
            this.mainThread = mainThread;
            this.competionQueue = competionQueue;
        }

        @Override
        public void run() {
            try {
                while(true) {

                    final Future<Integer> future = competionQueue.take();

                    final Integer result = future.get();

                    System.out.println(result);

                    if (result == 10) {
                        mainThread.interrupt();
                        break;
                    }
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

        }
    }
}
