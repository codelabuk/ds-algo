package org.example.ds.algo;

public class QuickSort {
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = partition(arr, low, high);
            quickSort(arr, low, mid);
            quickSort(arr, mid +1, high);
        }
    }

    int partition(int[] arr, int l, int h) {
        int pivot = arr[l]; // take 1st element as pivot
        int i = l, j = h; // take 1st index
        // swapping
        while (i < j) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

            int temp = arr[l];
            arr[l] = arr[j];
            arr[j] = temp;

        }
        return  j;


    }
}
