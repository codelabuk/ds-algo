package org.example.ds.leetcode.hashtables.problem1512;

import java.util.HashMap;

public class FindNumberIdenticalPair {

    public int identicalPair(int[] num) {
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] == num[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int identicalPairV1(int[] nums) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            if (resultMap.containsKey(num)) {
                count += resultMap.get(num);
                resultMap.put(num, resultMap.get(num) + 1);
            } else {
                resultMap.put(num, 1);
            }
        }
        return count;
    }
}
