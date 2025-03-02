package org.example.threading;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerBlockingQueue implements Runnable {
    private BlockingQueue<Integer> queue;

    ProducerBlockingQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(1000);
                queue.put(i);
                System.out.println("Producer :" + i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class ConsumerBlockingQueue implements Runnable {
    private BlockingQueue<Integer> queue;

    ConsumerBlockingQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true){
                Integer item = queue.take();
                System.out.println("Consumed :" + item);
                Thread.sleep(2000);  // Consumer is slower
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class BlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        ProducerBlockingQueue producerBlockingQueue = new ProducerBlockingQueue(queue);
        ConsumerBlockingQueue consumerBlockingQueue = new ConsumerBlockingQueue(queue);

        Thread producerThread = new Thread(producerBlockingQueue);
        Thread consumerThread = new Thread(consumerBlockingQueue);

        producerThread.start();
        consumerThread.start();

    }



}
