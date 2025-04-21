package org.example1.practice.array;

public class RotateArrayByDIndex {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, 7, 8, 9, 6};

        leftRotateByD(arr, arr.length, 4);

        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + ",");
        }
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
}
