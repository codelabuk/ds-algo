package org.example.ds.interview;

import java.util.*;

/**
 * Expected Answer is 1, 13, 17,18,19,24, 32
 * We need to iterate from 1st array
 *
 *
 */
public class ArrayMergePattern {
    public static void main(String[] args) {
        int[] arr1 = {1, 13, 15, 18, 19, 24, 28};
        int[] arr2 = {2, 13, 17, 18, 20, 24, 32};
        List<Integer> result = new ArrayList<>();
        int[] result1 = new int[arr1.length];
        int i= 0, j = 0;
        int k = i;
        result.add(arr1[i]);
        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] == arr2[j]) {
                result.add(arr1[k]);

                i++;
                j++;
            } else {
                if(result.isEmpty()){
                    result.add(arr1[i]);
                    result1[i] = arr1[i];
                }
                if (result.size() == i && !result.contains(arr1[i])){
                    result.add(arr1[i]);

                }
                if(result.size() == j && !result.contains(arr2[j])){
                    result.add(arr2[j]);
                }
                j++;
                i++;

            }
        }


        System.out.println(result);

    }
}
