package io.marble.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTaskTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CountDownLatch latch = new CountDownLatch(10);
        List<CompletableFuture<Void>> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(new CountDownLatchTask(latch));
            list.add(voidCompletableFuture);
        }
        latch.await();
        System.out.println("记数的任务已完成");
        for (CompletableFuture<Void> voidCompletableFuture : list) {
            voidCompletableFuture.get();
        }
    }
}

class CountDownLatchTask implements Runnable{
    private CountDownLatch latch;

    CountDownLatchTask(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        int i = new Random().nextInt(10000);
        try {
            TimeUnit.MILLISECONDS.sleep(i);
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + "任务完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
