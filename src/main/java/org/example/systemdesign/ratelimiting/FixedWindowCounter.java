package org.example.systemdesign.ratelimiting;

import java.time.Instant;

public class FixedWindowCounter {
    private final long windowSizeInSeconds;
    private final long maxRequestPerWindow;
    private long currentWindowStart;
    private long requestCount;


    public FixedWindowCounter(long windowSizeInSeconds, long maxRequestPerWindow) {
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.maxRequestPerWindow = maxRequestPerWindow;
        this.currentWindowStart = Instant.now().getEpochSecond();
        this.requestCount = 0;
    }

    public synchronized boolean allowRequest() {
        long now = Instant.now().getEpochSecond();
        if (now - currentWindowStart >= windowSizeInSeconds) {
            currentWindowStart = now; // Start a new Window
            requestCount = 0; // Reset the count for new window.
        }
        if (requestCount < maxRequestPerWindow) {
            requestCount++;
            return true;
        }
         return false;
    }


}
