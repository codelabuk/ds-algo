package org.example1.threading;

public class ThreadExample {

    public static class StoppableRunnable implements  Runnable{

        private boolean stopRequested = false;
        public synchronized boolean isStopRequested() {
            return stopRequested;
        }

        public synchronized void requestStop() {
            this.stopRequested = true;
        }

        private void sleep(long millisecs){
            try {
                Thread.sleep(millisecs);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            System.out.println("StoppableRunnable running");
            while(!isStopRequested()){
                sleep(1000);
                System.out.println("....");
            }
            System.out.println("StoppableRunnable stopped");
        }
    }

    public static void main(String[] args) {
        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread thread = new Thread(stoppableRunnable, "The thread");
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        stoppableRunnable.requestStop();
        System.out.println("stop requested");
    }
}
