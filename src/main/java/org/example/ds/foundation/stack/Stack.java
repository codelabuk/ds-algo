package org.example.ds.foundation.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Stack<T> implements Iterable<T> {

    private LinkedList<T> list = new LinkedList<>();
    public Stack(){}

    public Stack (T firstElem){}

    public int size() {
        return list.size();
    }
    public boolean isEmpty() {return size() == 0;}

    public void push(T elem ){
        list.addLast(elem);
    }
    public void addLast(T elem){
        list.addLast(elem);
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        return list.removeLast();
    }

    public  T peek() {
        if (isEmpty())
            throw  new EmptyStackException();
        return list.peekLast();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
