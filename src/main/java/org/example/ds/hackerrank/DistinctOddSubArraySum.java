package org.example.ds.hackerrank;

import java.util.HashSet;

public class DistinctOddSubArraySum {

    /**
     * @param arr
     * @param k
     * @return
     */
    private static int distinctSubArraySum(int[] arr, int k) {
        int n = arr.length;
        int currentSum = 0;
        int maxSum = 0;
        int l = 0;
        HashSet<Integer> distinctSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                arr[i]--;
            }
        }

        for (int r = 0; r < n; r++) {

            while (distinctSet.contains(arr[r])) {
                distinctSet.remove(arr[l]);
                currentSum -= arr[l];
                l++;
            }

            distinctSet.add(arr[r]);
            currentSum += arr[r];

            if (r - l + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
                distinctSet.remove(arr[l]);
                currentSum -= arr[l];
                l++;
            }
        }

        return maxSum;

    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 1};
        System.out.println("Distinct Odd SumArray : " + distinctSubArraySum(arr, 2));

        int[] arr1 = {1, 1, 1};
        System.out.println("Distinct Odd SumArray : " + distinctSubArraySum(arr1, 2));

        int[] arr2 = {1, 2, 3, 4 ,5, 6, 7, 10, 15, 17};
        System.out.println("Distinct Odd SumArray : " + distinctSubArraySum(arr2, 5));

    }
}
