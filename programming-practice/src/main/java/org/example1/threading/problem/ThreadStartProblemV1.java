package org.example1.threading.problem;

import java.util.concurrent.CountDownLatch;

/**
 * Using CountDownLatch
 */
public class ThreadStartProblemV1 {
    public static void main(String[] args) {

        CountDownLatch latch1  = new CountDownLatch(1);
        CountDownLatch latch2  = new CountDownLatch(1);
        CountDownLatch latch3  = new CountDownLatch(1);


        Thread t1 = new Thread(()->{
            System.out.println("Thread 1 is started");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException ie){}
            System.out.println("Thread 1 is finished");
            latch1.countDown();
        });


        Thread t2 = new Thread(()->{
            try {
                latch1.await();
            } catch (InterruptedException e) {

            }
            System.out.println("Thread 2 is started");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException ie){}
            System.out.println("Thread 2 is finished");
            latch2.countDown();
        });
        Thread t3 = new Thread(()->{
            try {
                latch2.await();
            } catch (InterruptedException e) {

            }
            System.out.println("Thread 3 is started");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException ie){}
            System.out.println("Thread 3 is finished");
            latch3.countDown();
        });


        t1.start();
        t2.start();
        t3.start();

    }
}
