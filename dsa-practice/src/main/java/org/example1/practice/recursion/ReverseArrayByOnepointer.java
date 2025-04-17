package org.example1.practice.recursion;

public class ReverseArrayByOnepointer {

    static void reverse(int[] arr, int i, int n) {
        if (i >= n/2) return;
        swap(arr, i, n-i-1);
        reverse(arr, i + 1, n);
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 5, 4};
        int l = 0, n = arr.length;
        reverse(arr, l, n);
        for (int i = 0; i <n; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
