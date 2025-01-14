package org.example.ds.leetcode.queue.problem933;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Using Queue - Time Complexity - O(1), space complexity - O(n)
class RecentCounterUsingArray {

    private ArrayList<Integer> calls;
    public RecentCounterUsingArray() {
        calls = new ArrayList<>();
    }

    public int ping(int t) {
        int count = 0;
        calls.add(t);
        int start = t-3000;
        for(int time : calls){
            if( time >= start && time <= t){
                count ++;
            }
        }
        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */