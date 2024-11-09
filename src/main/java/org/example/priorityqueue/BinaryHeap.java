package org.example.priorityqueue;

import java.util.*;

/**
 *
 * @param <T>
 */
public class BinaryHeap<T extends  Comparable<T>> {
    // dynamic list to track element inside heap
    private List<T> heap = null;
    // Construct & initialize empty priority queue
    public BinaryHeap(){
        this(1);
    }

    // Construct a priority queue with an initial capacity
    public BinaryHeap(int size){
        heap = new ArrayList<>(size);
    }

    // Construct a priority queue using heapify in O(n) time
    public BinaryHeap(T[] elems) {
        int heapSize = elems.length;
        heap = new ArrayList<>(heapSize);

        // place all the element in heap
        for (int i = 0; i < heapSize; i++) {
            heap.add(elems[i]);
        }

        // Heapify process - O(n)
        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--) {
            sink(i);
        }
    }

    public BinaryHeap(Collection<T> elems) {
        int heapSize = elems.size();
        heap = new ArrayList<>(heapSize);

        heap.addAll(elems);

        // Heapify process - O(n)
        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--) {
            sink(i);
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // CLear everything inside heap
    public void clear(){
        heap.clear();
    }

    // Return size of the heap
    public int size(){
        return heap.size();
    }

    /* Return the value of element with the lowest priority
    * in the priority queue.
    * If priority queue is empty , return null
    */
    public T peek(){
        if(isEmpty()) return  null;
        return  heap.get(0);
    }

    private boolean less(int i, int j){
      return  heap.get(i).compareTo(heap.get(j)) <= 0;
    }
    private void sink(int k) {
        int heapSize = size();
        while (true) {
            int left = 2 * k + 1; // left node
            int right = 2 * k + 2; // Right node
            int smallest = left; // Assume left is the smallest node

            if (right < heapSize && less(right, left))
                smallest = right;

            if (left >= heapSize || less(k, smallest)) break;

            swap(smallest, k);
            k = smallest;
        }

    }

    private  void swap(int i  , int j){
        T elem_i = heap.get(i);
        T elem_j = heap.get(j);

        heap.set(i, elem_j);
        heap.set(j, elem_i);
    }

    // Bottom up approach , O(log (n))
    // Compare current node with parent node
    private void swim(int k){
        int parent = (k-1)/2;

        while(k > 0 && less(k, parent)){
            // Exchange k with parent
            swap(parent, k);
            k = parent;
            // Grab the index of next parent w.r.t K
            parent = (k-1)/ 2;
        }

    }

    // Adding the element to priority queue
    public void add(T elem) {
        if (elem == null) throw new IllegalArgumentException();
        heap.add(elem);
        int indexOfLastElem = size() -1;
        swim(indexOfLastElem);
    }

    public boolean contains(T elem) {
        return heap.contains(elem);
    }

    public boolean remove(T elem){
        if(elem == null) return false;

        for(int j = 0; j < size(); j++){
            if(elem.equals(heap.get(j))){
                removeAt(j);
                return  true;
            }
        }
        return false;
    }

    public T removeAt(int i){
        if(isEmpty()) return  null;
        int indexOfLastElem = size() -1 ;
        T removedData = heap.get(i);
        swap(i, indexOfLastElem);
        heap.remove(indexOfLastElem);
        if (i == indexOfLastElem) {
            return removedData;
        }
        T elem = heap.get(i);
        sink(i);
        if(heap.get(i).equals(elem)) {
            swim(i);
        }

        return removedData;
    }

    public  boolean isMinHeap(int k){
        int heapSize = size();

        if(k >= heapSize) return  true;

        int left = 2*k + 1;
        int right = 2*k + 2;
        /**
         * Ensure current node k is less than both of it's children
         * left & right
         */
        if (left < heapSize && !less(k,left)) return false;
        if (right < heapSize && !less(k, right)) return  false;

        return  isMinHeap(left) && isMinHeap(right);

    }

    @Override
    public String toString() {
        return "BinaryHeap{" +
                "heap=" + heap +
                '}';
    }

}


