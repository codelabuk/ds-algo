package org.example1.practice.array;

public class RotateArrayByfirstIndex {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, 7,8};

        int temp = arr[0];
        int n= arr.length;
        for (int i = 1; i < n; i++) {
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;

    }
}
