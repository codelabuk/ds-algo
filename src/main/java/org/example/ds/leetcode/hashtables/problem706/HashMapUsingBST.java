package org.example.ds.leetcode.hashtables.problem706;

import java.util.TreeMap;

/**
 * Using Binary Search Tree in Buckets
 * Time Complexity - O(log n)
 */
public class HashMapUsingBST {
    private TreeMap<Integer, Integer>[] map;
    private int SIZE = 1000;

    HashMapUsingBST() {
        map = new TreeMap[SIZE];
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        if (map[index] == null) {
            map[index] = new TreeMap<>();
        }
        map[index].put(key, value);
    }

    public int get(int key) {
        int index = getIndex(key);
        return map[index] != null ? map[index].getOrDefault(key, -1) : -1;
    }

    /**
     *
     * @param key
     */
    public void remove(int key) {
        int index = getIndex(key);
        if (map[index] != null) {
            map[index].remove(key);
        }
    }

}
