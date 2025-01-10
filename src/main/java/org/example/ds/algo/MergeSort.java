package org.example.ds.algo;

public class MergeSort {

    void mergeSort(int[] arr , int left , int right){
        if(left < right){
            int mid = (left + right)/2;
            mergeSort( arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
    void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        // create left & right array from mid
        int[] left_arr = new int[n1];
        int[] right_arr = new int[n2];
        // fill the element with left & right array
        for (int i = 0; i < n1; i++) {
            left_arr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            right_arr[j] = arr[mid + 1 + j];
        }
        // actual merge
        int i = 0, j = 0, k = left;
        // merge the 2 array
        while (i < n1 && j < n2) {
            // compare both array at index i, j & fill the main array
            if (left_arr[i] < right_arr[j]) {
                arr[k++] = left_arr[i++];
            } else {
                arr[k++] = right_arr[j++];
            }
        }
        // fill the remaining from left array
        for (; i < n1; i++) {
            arr[k++] = left_arr[i];
        }
        for (; j < n2; j++) {
            arr[k++] = right_arr[j];
        }
    }

}
