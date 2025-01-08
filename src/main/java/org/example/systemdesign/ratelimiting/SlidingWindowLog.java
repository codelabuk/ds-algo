package org.example.systemdesign.ratelimiting;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowLog {
    private final long windowSizeInSeconds; // Size of sliding window in seconds
    private final long maxRequestPerWindow; // Maximum no. of requests in a window
    private Queue<Long> requestLog; // Log of request timestamps

    public SlidingWindowLog(long windowSizeInSeconds, long maxRequestPerWindow) {
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.maxRequestPerWindow = maxRequestPerWindow;
        this.requestLog = new LinkedList<>();
    }

    public synchronized boolean allowRequest() {
        long now = Instant.now().getEpochSecond();
        long windowSTart = now - windowSizeInSeconds;

        // Remove the timestamp that are outside of current window
        while (!requestLog.isEmpty() && requestLog.peek() <= windowSTart) {
            requestLog.poll();
        }
        if (requestLog.size() < maxRequestPerWindow) {
            requestLog.offer(now);
            return true;
        }
        return false;
    }
}
