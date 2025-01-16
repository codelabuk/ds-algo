package org.example.ds.leetcode.queue.problem933;

import java.util.LinkedList;
import java.util.Queue;

// Using Queue - Time Complexity - O(n) , Space Complexity - O(n)
// Sliding Window for including 3000
class RecentCounter {

    private Queue<Integer> calls;
    public RecentCounter() {
        calls = new LinkedList<>();
    }

    public int ping(int t) {
        calls.offer(t); // Add the timestamp to the queue
        while (calls.peek() < t - 3000){ // check at the head of the queue but doesn't remove it yet
            calls.poll(); // remove from queue
        }
        return calls.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */