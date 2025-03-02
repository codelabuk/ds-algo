package org.example.threading;

public class CreateTheadLocalExample {

    public static void main(String[] args) {
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        Thread objThread = new Thread( ()->{
           inheritableThreadLocal.set("labuk");
           threadLocal.set(1235);

           Thread childThread = new Thread(() ->{
               System.out.println(inheritableThreadLocal.get());
               System.out.println(threadLocal.get());
           });
           childThread.start();
        });
        objThread.start();

    }
}
