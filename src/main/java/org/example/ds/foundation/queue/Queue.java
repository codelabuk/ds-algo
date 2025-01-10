package org.example.ds.foundation.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Queue<T> implements  Iterable<T> {

    private LinkedList<T> list= new LinkedList<>();

    public Queue(){}

    public Queue(T firstElem){
        offer(firstElem);
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Empty Queue");
        return list.peekFirst();
    }

    public T poll(){
        if(isEmpty())
            throw  new RuntimeException("Empty Queue");
        return list.removeFirst();
    }

    public void offer(T elem){
        list.addLast(elem);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
