package com.demo.test;

public class ExecutorJob implements Runnable {
    @Override
    public void run() {

        try {
            System.out.println("子线程开始运行");
            Thread.sleep(5000);
            System.out.println("子线程结束运行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
