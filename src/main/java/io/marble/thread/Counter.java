package io.marble.thread;

public class Counter {
    private Object object = new Object();
    public int getSum() {
        return sum;
    }

    private int sum = 0;

    //1.添加synchronized
    private synchronized void addNum() {
        synchronized (this){
            sum = sum + 1;
        }
        synchronized (object){
            sum = sum + 1;
        }

    }


    public static void main(String[] args) throws InterruptedException {
        //单线程
        Counter counter = new Counter();
        for (int i = 0; i < 100000; i++) {
            counter.addNum();
        }
        System.out.println("单线程结果：" + counter.getSum());
        Counter counter1 = new Counter();

        new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter1.addNum();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter1.addNum();
            }
        }).start();
        Thread.sleep(2000);
        System.out.println("多线程结果：" + counter1.getSum());

    }
}
