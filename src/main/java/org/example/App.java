package org.example;

import org.example.ds.foundation.priorityqueue.BinaryHeap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        BinaryHeap<Integer> minHeap = new BinaryHeap<>();
        minHeap.add(8);
        minHeap.add(3);
        minHeap.add(5);
        minHeap.add(10);
        minHeap.add(2);

        System.out.println("Min Heap : {}"+ minHeap);
    }


}
