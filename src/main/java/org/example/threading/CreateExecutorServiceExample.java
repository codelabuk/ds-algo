package org.example.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateExecutorServiceExample {

    public static void main(String[] args) {
        ExecutorService singleThreadedExecutor = Executors.newSingleThreadExecutor();
        for(int i = 0; i <=5; i++) {
            final int taskId = i;
            singleThreadedExecutor.execute(() -> {
                System.out.println("Single threaded task " + taskId + " executed by : " +
                        Thread.currentThread().getName());
            });
        }
        singleThreadedExecutor.shutdown();


        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for(int i = 0; i <=5; i++) {
            final int taskId = i;
            fixedThreadPool.execute(() -> {
                System.out.println("Fixed threaded task " + taskId + " executed by : " +
                        Thread.currentThread().getName());
            });
        }
        fixedThreadPool.shutdown();

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i = 0; i <=5; i++) {
            final int taskId = i;
            cachedThreadPool.execute(() -> {
                System.out.println("Cached threaded task " + taskId + " executed by : " +
                        Thread.currentThread().getName());
            });
        }
        cachedThreadPool.shutdown();
    }
}
