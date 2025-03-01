package org.example.threading;

public class CreateThreadExampke {
    public static void main(String[] args) {
        System.out.println("Hello World !!");
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 running");
        });
        thread1.start();
        Runnable runnable = () -> {
            System.out.println("Thread 2 is running");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 2 is completed");
        };
        Thread thread2 = new Thread(runnable, "Runnable Thread");
        thread2.setDaemon(true);
        thread2.start();
        System.out.println("Main thread ended ");


    }
}
