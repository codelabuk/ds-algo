package org.example1.practice.twopointer;

public class LongestSubArraySumK {

    static int bruteForceSolution(int[] arr, int k) {

        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else if (sum > k) {
                    break;
                }
            }
        }
        return maxLen;
    }

    static int betterSolution(int[] arr, int k) {
        int r = 0, l = 0;
        int n = arr.length;
        int maxlen = 0, sum = 0;
        while (r < n) {
            sum = sum + arr[r];
            while (sum > k) {
                sum = sum - arr[l];
                l = l + 1;
            }
            if (sum <= k) {
                maxlen = Math.max(maxlen, r - l + 1);
            }
            r = r + 1;
        }
        return maxlen;
    }

    static int optimalSolution(int[] arr, int k) {
        int r = 0, l = 0;
        int n = arr.length;
        int maxlen = 0, sum = 0;
        while (r < n) {
            sum = sum + arr[r];
            if (sum > k) {
                sum = sum - arr[l];
                l = l + 1;
            }
            if (sum <= k) {
                maxlen = Math.max(maxlen, r - l + 1);
            }
            r = r + 1;
        }
        return maxlen;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 1, 7, 10};
        System.out.println(bruteForceSolution(arr, 15));
        System.out.println(betterSolution(arr, 15));
        System.out.println(optimalSolution(arr, 15));
    }
}
