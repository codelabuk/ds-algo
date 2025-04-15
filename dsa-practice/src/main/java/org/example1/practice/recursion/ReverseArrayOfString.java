package org.example1.practice.recursion;

public class ReverseArrayOfString {

    static void reverse(int[] arr, int l, int r) {
        if (l >= r) return;
        swap(arr, l, r);
        reverse(arr, l + 1, r - 1);
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 5, 4};
        int l = 0, r = arr.length - 1;
        reverse(arr, l, r);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
