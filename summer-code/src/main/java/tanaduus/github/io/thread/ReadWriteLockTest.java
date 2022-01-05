package tanaduus.github.io.thread;

import com.google.common.util.concurrent.CycleDetectingLockFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * @author 夏冬
 * @date 2021/6/15
 */
@Slf4j
public class ReadWriteLockTest {

    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    private static ReentrantReadWriteLock cycDetectionReentrantReadWriteLock = CycleDetectingLockFactory
            .newInstance(CycleDetectingLockFactory.Policies.THROW)
            .newReentrantReadWriteLock("cycLock");

    private static StampedLock stampedLock = new StampedLock();

    public static void main(String[] args) throws InterruptedException {

//        testRW();

//        testRWcycle();

        testSt();
    }

    private static void testRW() throws InterruptedException {

        new Thread(() -> {
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

            try {
                readLock.lock();
                log.info("readLock lock");

                TimeUnit.SECONDS.sleep(5L);
            } catch (Throwable t) {
                t.printStackTrace();
            } finally {
                log.info("readLock unlock");
                readLock.unlock();
            }

        }, "t1").start();

        TimeUnit.SECONDS.sleep(1L);

        new Thread(() -> {
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

            try {
                readLock.lock();
                log.info("readLock lock");

                TimeUnit.SECONDS.sleep(5L);
            } catch (Throwable t) {
                t.printStackTrace();
            } finally {
                log.info("readLock unlock");
                readLock.unlock();
            }

        }, "t2").start();

        new Thread(() -> {
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

            try {
                writeLock.lock();
                log.info("writeLock lock");

                TimeUnit.SECONDS.sleep(5L);
            } catch (Throwable t) {
                t.printStackTrace();
            } finally {
                log.info("writeLock unlock");
                writeLock.unlock();
            }
        }, "t3").start();

        TimeUnit.SECONDS.sleep(1L);

        new Thread(() -> {
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

            try {
                readLock.lock();
                log.info("readLock lock");

                TimeUnit.SECONDS.sleep(5L);
            } catch (Throwable t) {
                t.printStackTrace();
            } finally {
                log.info("readLock unlock");
                readLock.unlock();
            }

        }, "t4").start();
    }

    private static void testRWcycle() throws InterruptedException {

        new Thread(() -> {
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

            try {
                readLock.lock();
                log.info("readLock lock");

                writeLock.lock();
                log.info("writeLock lock");
                TimeUnit.SECONDS.sleep(5L);
            } catch (Throwable t) {
                t.printStackTrace();
            } finally {
                log.info("writeLock unlock");
                writeLock.unlock();

                log.info("readLock unlock");
                readLock.unlock();
            }

        }, "t1").start();

        TimeUnit.SECONDS.sleep(1L);

        new Thread(() -> {
            ReentrantReadWriteLock.ReadLock readLock = cycDetectionReentrantReadWriteLock.readLock();
            ReentrantReadWriteLock.WriteLock writeLock = cycDetectionReentrantReadWriteLock.writeLock();

            try {
                readLock.lock();
                log.info("readLock lock");

                writeLock.lock();
                log.info("writeLock lock");

                log.info("{},{}", cycDetectionReentrantReadWriteLock.getReadLockCount(), cycDetectionReentrantReadWriteLock.getReadHoldCount());
                TimeUnit.SECONDS.sleep(5L);
            } catch (Throwable t) {
                t.printStackTrace();
            } finally {
                log.info("writeLock unlock");
                writeLock.unlock();

                log.info("readLock unlock");
                readLock.unlock();
            }

        }, "t2").start();
    }

    private static void testSt() throws InterruptedException {

        long optimisticRead = stampedLock.tryOptimisticRead();

        new Thread(() -> {
            Lock writeLock = stampedLock.asWriteLock();
            writeLock.lock();
            try {

                log.info("write");
            } finally {
                writeLock.unlock();
            }
        }).start();


        TimeUnit.SECONDS.sleep(1);

        log.info("validate:{}"+stampedLock.validate(optimisticRead));
    }
}
