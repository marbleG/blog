package io.marble.thread;

public class DaemonThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //设置为daemon线程，主线程结束后，jvm关闭
        thread.setDaemon(true);
        thread.start();


    }
}
