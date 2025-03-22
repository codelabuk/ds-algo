package org.example.ds.pattern.prefixsum.test;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {

    public static int subarraySum(int[] nums, int k) {

        int prefixSum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            prefixSum += num;
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+ 1);
        }
        return  count;
    }

    public static void main(String[] args) {
        int[] arrr = {1, 2, 1,2, 3};
        System.out.println("Output = " + subarraySum(arrr, 3));
    }
}
