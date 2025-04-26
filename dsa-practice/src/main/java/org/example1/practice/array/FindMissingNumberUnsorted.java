package org.example1.practice.array;

public class FindMissingNumberUnsorted {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 7, 1, 2, 8, 4, 5};
        System.out.println(findMissingNumberUnsorted(arr));
    }

    static int findMissingNumberUnsorted(int[] arr) {
        int n = arr.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int i : arr) {
            actualSum = actualSum + i;
        }

        return expectedSum - actualSum;
    }
}
