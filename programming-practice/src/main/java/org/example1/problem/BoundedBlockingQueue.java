package org.example1.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * using Wait / notifyAll
 */
public class BoundedBlockingQueue<T> {

    private final Queue<T> queue;
    private final int capacity;

    public BoundedBlockingQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // until space is available
        }
        queue.add(item);
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // until some item is there
        }
        T item = queue.remove();
        notifyAll();
        return item;
    }

    public synchronized int size() {
        return queue.size();
    }
}
