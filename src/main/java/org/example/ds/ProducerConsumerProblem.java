package org.example.ds;


import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

class Producer implements Runnable {
    BlockingQueue<Integer> queue;

    Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(1000);
                    queue.put(i);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

    public class ProducerConsumerProblem {


    }
