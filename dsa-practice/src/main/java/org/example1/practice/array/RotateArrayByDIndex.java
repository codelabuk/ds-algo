package org.example1.practice.array;

import java.util.Arrays;

public class RotateArrayByDIndex {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, 7, 8, 9, 6};

        int[] arr1 = new int[]{1, 3, 4, 2, 7, 8, 9, 6};

        leftRotateByD(arr, arr.length, 4);

        System.out.println(Arrays.toString(arr));
        leftRotateByDOptimal(arr1, arr1.length, 4);
        System.out.println(Arrays.toString(arr1));
    }

    private static void leftRotateByD(int[] arr, int n, int d) {
        d = d % n;
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        for (int i = d; i < n; i++) {
            arr[i - d] = arr[i];
        }

        for (int i = n - d; i < n; i++) {
            arr[i] = temp[i - (n - d)];
        }

    }

    /**
     *
     * @param arr
     * @param n
     * @param d
     */
    private static void leftRotateByDOptimal(int[] arr, int n, int d) {
        reverse(arr, 0, n - d - 1);
        reverse(arr, n - d, n - 1);
        reverse(arr, 0, n - 1);

    }

    private static void reverse(int[] arr, int x, int y) {
        while (x <= y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
            x++;
            y--;
        }
    }

}
