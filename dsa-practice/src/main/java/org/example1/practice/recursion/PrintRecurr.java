package org.example1.practice.recursion;

public class PrintRecurr {

    public static void main(String[] args) {
        print(1,3);
    }

    private static void print(int i, int n) {
        if(i > n) return;
        print(i+1, n);
        System.out.println(i);
    }
}
