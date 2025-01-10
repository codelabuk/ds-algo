package org.example.ds.foundation.hashtable;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;

class Entry<K, V>{
    int hash;
    K key;
    V value;

    public Entry(K key, V value){
        this.key = key;
        this.value= value;
        this.hash = key.hashCode();
    }

    public boolean equals(Entry<K, V> other) {
        if (hash != other.hash) return false;
        return key.equals(other.key);
    }


    @Override
    public String toString() {
        return key + "=>" + value;
    }
}


public class HashTableSeparateChaining<K,V> implements Iterable<K>{

    private static final int DEFAULT_CAPACITY = 3;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private double maxLoadFactor;
    private int capacity, threshold, size = 0;
    private LinkedList<Entry<K,V>>[] table;

    public HashTableSeparateChaining(){
     this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashTableSeparateChaining(int capacity){
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public HashTableSeparateChaining(int capacity, double maxLoadFactor){
        if (capacity< 0) throw  new IllegalArgumentException("Illegal capacity");
        if(maxLoadFactor <= 0 || Double.isNaN(maxLoadFactor) || Double.isInfinite(maxLoadFactor)){
            throw new IllegalArgumentException("Illegal maxLoadFactor");
        }
        this.maxLoadFactor = maxLoadFactor;
        this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
        threshold = (int)(this.capacity * maxLoadFactor);
        table = new LinkedList[this.capacity];
    }

    public int size() {
        return  size;
    }

    public boolean isEmpty(){
        return  size == 0;
    }


    // Converts a hash value to an index. Essentially, this strips the negative sign
    // & places the hash value in the domain
    public int normalizeIndex(int keyHash){
        return (keyHash & 0x7FFFFFF) % capacity;
    }

    public void clear(){
        Arrays.fill(table, null);
        size = 0; 
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super K> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<K> spliterator() {
        return Iterable.super.spliterator();
    }
}
