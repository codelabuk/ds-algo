package org.example.ds.algo;

// Binary Search for sorted array - O(log n)
public class BinarySearch {

    int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + (right - left)) / 2;
            if (array[mid] == target) {
                return array[mid];
            } else if (target < array[mid]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;
    }

}
