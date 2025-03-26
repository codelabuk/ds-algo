package org.example.threading.problem;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Using CountDownLatch
 */
public class ThreadStartProblemV2 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(() -> {
            System.out.println("Thread 1 is started");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
            }
            System.out.println("Thread 1 is finished");
        });

        executorService.submit(() -> {
            System.out.println("Thread 2 is started");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
            }
            System.out.println("Thread 2 is finished");
        });

        executorService.submit(() -> {
            System.out.println("Thread 3 is started");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
            }
            System.out.println("Thread 3 is finished");
        });

        executorService.shutdown();

    }
}
