package org.example.threading.problem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * Using CountDownLatch
 */
public class ThreadStartProblemV3 {
    public static void main(String[] args) {

        SynchronousQueue<Integer> queue1 = new SynchronousQueue<>();
        SynchronousQueue<Integer> queue2 = new SynchronousQueue<>();

        Thread t1 = new Thread(()->{
            System.out.println("Thread 1 is started");
            try{
                Thread.sleep(1000);
                queue1.put(1);
            }catch (InterruptedException ie){}
            System.out.println("Thread 1 is finished");
        });


        Thread t2 = new Thread(()->{
            try {
                queue1.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 2 is started");
            try{
                Thread.sleep(1000);
                queue2.put(1);
            }catch (InterruptedException ie){}
            System.out.println("Thread 2 is finished");
        });
        Thread t3 = new Thread(()->{
            try {
                queue2.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 3 is started");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException ie){}
            System.out.println("Thread 3 is finished");
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
