package tanaduus.github.io.thread;

import java.util.LinkedList;

/**
 * 同步容器
 * 生产者消费者
 */
public class ProCus {

    /**
     * 为什么不写volatile，因为synchronized保证了内存的可见性。不需要volatile再次保证。
     */
    private /*volatile*/ LinkedList list = new LinkedList();
    private int maxSize = 5;
    private /*volatile*/ int count = 0;

    public synchronized void put(Object o){
        while(list.size()==maxSize){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list.add(o);
        count++;

        /**
         * 必须notifyAll
         * 假如notify或者不写notify
         * 唤醒了一个生产者，继续进入本方法然后释放锁，然后又是生产者进来。
         * 有可能很多次之后，才会被消费者得到锁，去消费掉资源以让生产者继续生产。
         */
        this.notifyAll();
    }

    public synchronized void get(){
        while(list.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.poll();
        this.notifyAll();
    }

    public static void main(String[] args) {

    }
}
