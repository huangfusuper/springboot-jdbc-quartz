package com.demo.test;

import org.junit.Test;

import java.util.concurrent.*;

public class ExecutorsTest {
    @Test
    public void test() throws InterruptedException {
        String name = saveData("皇甫");
        System.out.println(name);
        Thread.sleep(100000);
    }

    public String saveData(String name){
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(10);
        ThreadPoolExecutor threadPoolExecutor
                = new ThreadPoolExecutor(1, 1, 5,
                TimeUnit.SECONDS, blockingQueue);

        threadPoolExecutor.submit(new ExecutorJob());
        threadPoolExecutor.shutdown();

        return name;
    }
}
