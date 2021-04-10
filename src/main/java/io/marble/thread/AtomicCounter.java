package io.marble.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger sum = new AtomicInteger(0);

    public int incrAndGet() {
        return sum.incrementAndGet();
    }

    public int getSum() {
        return sum.get();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicCounter counter = new AtomicCounter();
        new Thread(() -> {
            for (int i = 0; i < 5_0000; i++) {
                counter.incrAndGet();
            }

        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5_0000; i++) {
                counter.incrAndGet();
            }
        }).start();
        Thread.sleep(2000);
        System.out.println(counter.getSum());
    }
}
