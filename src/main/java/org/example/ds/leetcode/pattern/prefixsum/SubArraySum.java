package org.example.ds.leetcode.pattern.prefixsum;

import java.util.HashMap;

public class SubArraySum {

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        for (int num : nums) {
            currentSum += num;
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arrr = {1, 2, 3};
        System.out.println("Output = " + subarraySum(arrr, 3));
    }
}
