package org.example1.practice.stacknqueue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Brute Force Implementation
 */
public class LRUCache {

    int capacity;
    List<Integer> keys;
    Map<Integer, Integer> map;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
    }


}
