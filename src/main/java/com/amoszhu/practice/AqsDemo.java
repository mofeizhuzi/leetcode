package com.amoszhu.practice;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhuliangzhou
 */
public class AqsDemo {
    private static int value;
    private static Object object = new Object();
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i <= 200; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    value ++;
                } finally {
                    lock.unlock();
                }

                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println(value);
    }
}
