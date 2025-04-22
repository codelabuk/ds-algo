package org.example1.practice.twopointer;

public class ConstantWindowSum {

    private static int solution(int[] arr, int k) {
        int l = 0, r = k - 1;
        int n = arr.length;
        int sum = 0;
        int maxSum = 0;

        for (int i = l; i <= r; i++) {
            sum = sum + arr[i];
            maxSum = Math.max(maxSum, sum);
        }
        while (r < n-1) {
            sum = sum - arr[l];
            l++;
            r++;
            sum = sum + arr[r];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 2, 3, 3, 4, 5, -1};
        System.out.println(solution(arr, 4));

        int[] arr1 = new int[]{8, 2, 3, 3, 4, 5, 21};
        System.out.println(solution(arr1, 4));

    }
}
