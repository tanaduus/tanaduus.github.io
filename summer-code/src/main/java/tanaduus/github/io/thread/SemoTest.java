package tanaduus.github.io.thread;

import java.util.concurrent.Semaphore;

public class SemoTest {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(5);

        for(int i=0;i<100;i++){
            Thread.sleep(1000);
            new Thread(()->{
                try {
                    semaphore.acquire();

                    System.out.println("t");
                    Thread.sleep(10000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
