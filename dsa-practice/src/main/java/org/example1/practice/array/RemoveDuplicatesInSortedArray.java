package org.example1.practice.array;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicatesInSortedArray {

    static int[] bruteforceSOl(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }


    static int optimal(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        return i + 1;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 3, 3, 5, 8};

        System.out.println(bruteforceSOl(arr));
        System.out.println(optimal(arr));

    }
}
