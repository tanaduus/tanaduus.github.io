package tanaduus.github.io.thread;

import java.util.concurrent.TimeUnit;

public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {

//        Thread.currentThread().interrupt();

        Thread t1 = new Thread("t1") {

            @Override
            public void run(){

                System.out.println("t1:"+Thread.currentThread().isInterrupted());
                System.out.println("t1 this:"+this.isInterrupted());

                while(true){

                    try {
                        TimeUnit.SECONDS.sleep(10);
                        System.out.println("wake up");
                    } catch (InterruptedException e) {
                        System.out.println("t1:"+Thread.currentThread().isInterrupted());
                        e.printStackTrace();
//                        Thread.currentThread().interrupt();
                    }


//                    if(Thread.interrupted()) {
//                        System.out.println("ok");
//                    }

                    if(Thread.currentThread().isInterrupted()) {
                        System.out.println("ok");
                        break;
                    }
                }

                System.out.println("t1:"+Thread.currentThread().isInterrupted());
                System.out.println("t1 this:"+this.isInterrupted());

            }
        };

//        System.out.println(Thread.interrupted());

        t1.start();

        TimeUnit.SECONDS.sleep(5);

//        System.out.println(t1.isInterrupted());
        t1.interrupt();
//        System.out.println(t1.isInterrupted());

    }
}
