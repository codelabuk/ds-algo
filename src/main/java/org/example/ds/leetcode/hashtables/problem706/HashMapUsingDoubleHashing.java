package org.example.ds.leetcode.hashtables.problem706;

/**
 * Time Complexity - O(1)
 * Space Complexity - O(U)
 */
public class HashMapUsingDoubleHashing {
    private int[] map;
    private boolean[] present;
    private static final int DEFAULT_SIZE = 100001;

    HashMapUsingDoubleHashing() {
        map = new int[DEFAULT_SIZE];
        present = new boolean[DEFAULT_SIZE];
    }

    public void put(int key, int value) {
        map[key] = value;
        present[key] = true;
    }

    public int get(int key) {
        return present[key] ? map[key] : -1;
    }

    public void remove(int key) {
        present[key] = false;
    }

}
