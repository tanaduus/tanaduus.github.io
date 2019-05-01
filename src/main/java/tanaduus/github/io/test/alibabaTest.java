package tanaduus.github.io.test;

public class alibabaTest {

    static String[] ss = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n"};

    static int index = 0;

    public static boolean isYuan(String in){

        if("a".equals(in)||"e".equals(in)||"i".equals(in)||"o".equals(in)||"u".equals(in)){
            return true;
        }
        return false;
    }

    static Object lock = new Object();

    static public void printElement(String s){
        System.out.println(Thread.currentThread().getName()+s);
    }

    static class T1 extends Thread{

        @Override
        public void run(){
            while(true){
                synchronized(lock){
                    if(index>ss.length){
                        return;
                    }
                    String e = ss[index];
                    if(isYuan(e)){
                        printElement(e);
                        index++;
                    }
                    try {
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                }
            }

        }
    }

    static class T2 extends Thread{

        @Override
        public void run(){
            while(true){
                synchronized(lock){
                    if(index>ss.length){
                        return;
                    }
                    String e = ss[index];
                    if(!isYuan(e)){
                        printElement(e);
                        index++;
                    }
                    try {
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        }
    }

    public static void main(String[] args){

        T1 t1 = new T1();
        T2 t2 = new T2();

        t1.start();
        t2.start();

    }


}