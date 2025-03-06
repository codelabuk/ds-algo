package org.example.ds.pattern.prefixsum;

import java.util.HashMap;

public class ContigousSubArraySum {

    public static boolean checkSubArraySum(int[] nums, int k) {
        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (mod < 0) mod += k;

            if (modMap.containsKey(mod)) {
                if (i - modMap.get(mod) > 1) {
                    return true;
                }
            } else {
                modMap.put(mod, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{23,2,6,4,7};
        System.out.println("Contigous sub array sum "+ checkSubArraySum(arr, 13));

    }

}
