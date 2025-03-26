package org.example.threading.problem;



public class ThreadStartProblem {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("Thread 1 is started");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException ie){}
            System.out.println("Thread 1 is finished");
        });


        Thread t2 = new Thread(()->{
            System.out.println("Thread 2 is started");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException ie){}
            System.out.println("Thread 2 is finished");
        });
        Thread t3 = new Thread(()->{
            System.out.println("Thread 3 is started");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException ie){}
            System.out.println("Thread 3 is finished");
        });


        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();


    }

}
