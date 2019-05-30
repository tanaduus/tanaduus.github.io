package tanaduus.github.io.thread;

import java.util.concurrent.TimeUnit;

public class VolatileTest {

    static volatile int count = 10;
//    volatile VO vo;

    public static void main(String[] args) throws InterruptedException {

//        VolatileTest test = new VolatileTest();
//        test.vo = new VO("first");
//        System.out.println("main "+test.vo.hashCode());
//        System.out.println("main "+test.vo.getName());
//        System.out.println("main "+test.count);
//
//        new Thread(()->{
//            while(true){
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("subt "+test.vo.hashCode());
//                System.out.println("subt "+test.vo.getName());
//                System.out.println("subt "+test.count);
//            }
//        }).start();
//
//        TimeUnit.SECONDS.sleep(1);
////        test.vo = new VO("second");
//        test.count = 1;
////        test.vo.setName("third");
//        System.out.println("main "+test.vo.hashCode());
//        System.out.println("main "+test.vo.getName());
//        System.out.println("main "+test.count);
        VolatileTest test = new VolatileTest();

        while(count>0){
            new Thread(()->{
                count--;
                System.out.println(count);
            }).start();
        }

//        while(test.count>0){
//            new Thread(()->{
//                if(test.count==5){}
//                test.count--;
//                System.out.println(test.count);
//            }).start();
//        }
    }
}
