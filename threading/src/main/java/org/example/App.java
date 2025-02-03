package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newScheduledThreadPool(10);

        for(int i = 0; i<100; i++){
            executorService.execute(new Task());
        }

    }

    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread Name: "+ Thread.currentThread().getName());

        }
    }
}
