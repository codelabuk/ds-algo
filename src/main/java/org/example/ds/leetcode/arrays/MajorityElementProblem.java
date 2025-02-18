package org.example.ds.leetcode.arrays;


import java.util.HashMap;
import java.util.Map;

public class MajorityElementProblem {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > n / 2) {
                return num;
            }
        }
        return -1;
    }


    public static int majorityElementV1(int[] nums) {
        int count = 0;
        int candidate = nums[0];

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 2, 2, 1}; // {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority : " + majorityElementV1(nums));
    }
}
