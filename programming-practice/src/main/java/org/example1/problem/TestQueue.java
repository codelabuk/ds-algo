package org.example1.problem;

public class TestQueue {

    public static void main(String[] args) {
        BoundedBlockingQueue<Integer> queue = new BoundedBlockingQueue<>(5);

        Runnable producer = () -> {
            int i = 0;
            while (true){
                try{
                    queue.enqueue(i);
                    System.out.println("Enqueued: "+ i);
                    i++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable consumer = () -> {
            while (true) {
                try{
                    int item = queue.dequeue();
                    System.out.println("Dequeued : " + item);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
