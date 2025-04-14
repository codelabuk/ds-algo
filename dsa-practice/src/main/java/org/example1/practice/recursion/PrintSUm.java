package org.example1.practice.recursion;

public class PrintSUm {

    public static void main(String[] args) {
        print(3, 0);
    }

    private static void print(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }
        print(i - 1, sum + i);

    }
}
