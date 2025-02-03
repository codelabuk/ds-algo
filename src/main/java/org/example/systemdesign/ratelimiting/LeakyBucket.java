package org.example.systemdesign.ratelimiting;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class LeakyBucket {
    private final long capacity;  // maximum no. of request a bucket can hold
    private final double leakRate; // Rate at which request leaked out of the bucket
    private Queue<Instant> buckets;   // Current no. of tokens in the bucket
    private Instant lastLeakedTimestamp; // Last time we leaked from the bucket

    public LeakyBucket(long capacity, double leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
        this.buckets = new LinkedList<>();
        this.lastLeakedTimestamp = Instant.now();
    }

    public synchronized boolean allowRequest() {
        leak(); // leak out any request based on the elapsed time
        if (buckets.size() < capacity) {
            buckets.offer(Instant.now()); // Add the new request to the bucket
            return true;
        }
        return false;
    }

    private void leak() {
        Instant now = Instant.now();
        int leakedItems = (int) (now.toEpochMilli() - lastLeakedTimestamp.toEpochMilli() * leakRate / 1000);
        // Remove leaky item from bucket
        for (int i = 0; i < leakedItems && !buckets.isEmpty(); i++) {
            buckets.poll();
        }
        lastLeakedTimestamp = now;
    }
}
