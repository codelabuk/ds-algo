package org.example1.threading;

public class ThreadExample1 {
    public static void main(String[] args) {
        Runnable runnable = () ->{
            for(int i =0 ; i< 5; i++){
                sleep(1000);
                System.out.println("Running");
            }
        };
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sleep(long millisec){
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
