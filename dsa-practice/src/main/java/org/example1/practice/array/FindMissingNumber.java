package org.example1.practice.array;

import java.util.HashMap;

public class FindMissingNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5};
        int k = 5;
        System.out.println(bruteforce(arr, k));
        System.out.println(betterApproach(arr, k));
        System.out.println(optimalFirst(arr, k));
        System.out.println(optimalXor(arr, k));
    }

    static int bruteforce(int[] arr, int k) {
        int n = arr.length;

        for (int i = 1; i <= k; i++) {
            int flag = 0;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] == i) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) return i;
        }

        return 0;
    }

    static int optimalFirst(int[] arr, int k) {
        int sum = k * (k + 1) / 2;
        int s2 = 0;
        for (int i : arr) s2 = s2 + i;
        return sum - s2;
    }

    static int optimalXor(int[] arr, int k) {
        int xor1 = 0;
        int xor2 = 0;
        int n = k-1;
        for (int i = 1; i < n; i++) {
            xor1 = xor1 ^ arr[i];
            xor2 = xor2 ^ (i + 1);
        }
        xor1 = xor1 ^ n;
        return xor1 ^ xor2;
    }


    static int betterApproach(int[] arr, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = arr.length;

        for (int i = 1; i <= k; i++) {
            hashMap.put(i, 0);
        }

        for (int i = 0; i < n; i++) {
            hashMap.put(arr[i], 1);
        }

        System.out.println(hashMap);
        for (int j = 1; j <= k; j++) {
            Integer x = hashMap.get(j);
            if (x == null || x == 0) {
                return j;
            }

        }
        return 0;
    }
}
