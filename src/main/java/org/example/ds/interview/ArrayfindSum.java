package org.example.ds.interview;

import java.util.ArrayList;
import java.util.List;

public class ArrayfindSum {

    private static List<Integer> getArraySum(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int sum = 0;
        List<Integer> arrSum = new ArrayList<>();
        while (left < right) {
            sum = arr[left] + arr[right];
            if (sum == key) {
                arrSum.add(left);
                arrSum.add(right);
                return arrSum;
            }
            if (sum > key) {
                right--;
            } else {
                left++;
            }
        }
        return arrSum;
    }

    public static void main(String[] args) {
//        int[] numbers = new int[]{2,7,11,15};
//        int target =9;
//        System.out.println("Two sum : "+ getArraySum(numbers, target));

        int[] numbers = new int[]{5, 7, 11, 14, 15};
        int target = 21;
        System.out.println("Two sum : " + getArraySum(numbers, target));
    }
}
