package org.example.ds.algo;
// Time Complexity - O(2^n)
public class BubbleSort {

    public void bubbleSort(int[] arr) {
        int l = arr.length;
        for (int i = 0; i < l; i++) {
            for (int j = i; j < l - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
