package org.example.systemdesign.ratelimiting;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowCounter {
    private final long windowSizeInSeconds; // Size of sliding window in seconds
    private final long maxRequestPerWindow; // Maximum no. of requests in a window
    private long currentWindowStart;
    private long previousWindowCount;
    private long currentWindowCount;

    public SlidingWindowCounter(long windowSizeInSeconds, long maxRequestPerWindow) {
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.maxRequestPerWindow = maxRequestPerWindow;
        this.currentWindowStart = Instant.now().getEpochSecond();
        this.previousWindowCount = 0;
        this.currentWindowCount = 0;
    }

    public synchronized boolean allowRequest() {
        long now = Instant.now().getEpochSecond();
        long timePassedInWindow = now - currentWindowStart;

        if(timePassedInWindow >= windowSizeInSeconds){
            previousWindowCount = currentWindowCount;
            currentWindowCount = 0;
            currentWindowStart = now;
            timePassedInWindow = 0;
        }
        // Calculate the weight count
        double weightedCount = previousWindowCount * ((windowSizeInSeconds - timePassedInWindow)/windowSizeInSeconds)
                + currentWindowCount;
        if(weightedCount < maxRequestPerWindow) {
            currentWindowCount++;
            return  true;
        }

        return false;
    }
}
