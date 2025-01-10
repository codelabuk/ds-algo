package org.example.systemdesign.ratelimiting;

import java.time.Instant;

public class TokenBucket {
    private final long capacity;  // maximum no. of token a bucket can hold
    private final double fillRate; // Rate at which tokens are added to the bucket
    private double tokens;   // Current no. of tokens in the bucket
    private Instant lastRefillTimestamp; // Last time we refilled the bucket

    public TokenBucket(long capacity, double fillRate) {
        this.capacity = capacity;
        this.fillRate = fillRate;
        this.tokens = capacity;
        this.lastRefillTimestamp = Instant.now();
    }

    public synchronized boolean allowRequest(int tokens){
        refill();
        if (this.tokens < tokens){
            return false; // Not enough tokens, deny the request
        }
        this.tokens -= tokens;
        return true;
    }


    private void refill(){
        Instant now = Instant.now();
        // How many tokens to be added based on time elapsed
        double tokensToAdd = (now.toEpochMilli() - lastRefillTimestamp.toEpochMilli()) * fillRate/1000.0;
        this.tokens = Math.min(capacity, this.tokens + tokensToAdd); // Add tokens but don't exceed beyond capacity
        this.lastRefillTimestamp = now;
    }


}
