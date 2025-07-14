package org.example1.practice.problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int bruteForceSOl(int[] arr) {
        int longest = 1;
        int n = arr.length;
        int x = 0, count = 0;
        for (int i = 0; i < n; i++) {
            x = arr[i];
            count = 1;
            while (linearSearch(arr, x + 1)) {
                x = x + 1;
                count++;
            }

        }
        return count;
    }

    private static boolean linearSearch(int[] arr, int num) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * O(nlogn) + O(n)
     *
     * @param arr
     * @return
     */
    private static int betterSolution(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        Arrays.sort(arr);
        int longest = 1, count = 0;
        int lastSmaller = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] - 1 == lastSmaller) {
                count += 1;
                lastSmaller = arr[i];
            } else if (lastSmaller != arr[i]) {
                count = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(longest, count);
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{102, 4, 100, 1, 101, 3, 2, 2, 1};
        System.out.println(bruteForceSOl(arr));
        System.out.println(betterSolution(arr));
    }



}
