package org.example.ds.algo;

public class Fibonacci {
    int fibonacci(int n){
        if(n <= 1){
            return n;
        }
        return  fibonacci(n-1) + fibonacci(n-2);
    }
}
