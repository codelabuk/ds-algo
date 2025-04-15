package org.example1.practice.twopointer;

public class MaxConsecutiveOnes {

    private static int bruteForce(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int cZeros = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] == 0) {
                    cZeros++;
                }
                if (cZeros <= k) {
                    int len = j - i + 1;
                    maxLen = Math.max(maxLen, len);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    private static int betterSolution(int[] nums, int k) {
        int maxlen = 0;
        int l = 0, r = 0, cZeros = 0;

        while (r < nums.length) {
            if (nums[r] == 0) cZeros++;
            while (cZeros > k) {
                if (nums[l] == 0) cZeros--;
                l++;
            }
            if (cZeros <= k) {
                int len = r - l + 1;
                maxlen = Math.max(maxlen, len);
            }
            r++;
        }
        return maxlen;
    }

    private static int optimalSolution(int[] nums, int k) {
        int maxlen = 0;
        int l = 0, r = 0, cZeros = 0;

        while (r < nums.length) {
            if (nums[r] == 0) cZeros++;
            if (cZeros > k) {
                if (nums[l] == 0) cZeros--;
                l++;
            }
            if (cZeros <= k) {
                int len = r - l + 1;
                maxlen = Math.max(maxlen, len);
            }
            r++;
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(bruteForce(arr, 2));
        System.out.println(betterSolution(arr, 2));
        System.out.println(optimalSolution(arr, 2));
    }
}
