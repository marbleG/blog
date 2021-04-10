package io.marble.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreCounter {
    private int sum = 0;
    private Semaphore writeSemaphore = new Semaphore(1, true);
    private Semaphore readSemaphore = new Semaphore(100, true);

    public int incrAndGet() {
        try{
            writeSemaphore.acquireUninterruptibly();
            return ++sum;
        }finally {
            writeSemaphore.release();
        }
    }

    public int getSum() {
        try {
            readSemaphore.acquireUninterruptibly();
            return sum;
        }finally {
            readSemaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SemaphoreCounter semaphoreCounter = new SemaphoreCounter();
        new Thread(() -> {
            for (int i = 0; i < 5_0000; i++) {
                semaphoreCounter.incrAndGet();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5_0000; i++) {
                semaphoreCounter.incrAndGet();
            }
        }).start();
        Thread.sleep(2000);
        System.out.println(semaphoreCounter.getSum());
    }

}
