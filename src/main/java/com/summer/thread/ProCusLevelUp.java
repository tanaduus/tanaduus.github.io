package com.summer.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基于lock和Condition的生产者消费者--同步容器
 */
public class ProCusLevelUp {

    private Lock lock = new ReentrantLock();

    private List list = new LinkedList();

    private Condition addCondition = lock.newCondition();

    private Condition subCondition = lock.newCondition();

    private int maxSize = 5;

    public void add(Object o){
        try {
            lock.lock();
            //容器满，则等待
            while (list.size()==maxSize) {
                addCondition.await();
            }
            //容器未满，则进行生产
            list.add(o);
            //唤醒消费者进行消费
            subCondition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void sub(){
        try{
            lock.lock();
            while(list.size()==0){
                subCondition.await();
            }
            list.remove(0);
            addCondition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
