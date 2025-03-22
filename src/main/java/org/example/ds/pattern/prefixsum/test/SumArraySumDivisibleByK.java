package org.example.ds.pattern.prefixsum.test;

import java.util.HashMap;
import java.util.Map;

public class SumArraySumDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            prefixSum += num;
            int remainder = prefixSum % k;
            if (remainder < 0) remainder += k;
            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] arrr = {4, 5, 0, -2, -3, 1};
//        System.out.println("Output = " + subarraysDivByK(arrr, 5));

        int[] arr2 = {-2, 5, -4};
        System.out.println("Output = "+ subarraysDivByK(arr2, 5));
    }

}
