package tanaduus.github.io.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        for (int i = 0; i < 100; i++) {


            Thread.sleep(1000);

            int finalI = i;
            new Thread(() -> {
                try {
                    cyclicBarrier.await();

                    System.out.println(finalI);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
