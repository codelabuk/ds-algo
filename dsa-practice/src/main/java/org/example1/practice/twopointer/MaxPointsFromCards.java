package org.example1.practice.twopointer;

public class MaxPointsFromCards {

    static int solution(int[] arr, int k) {
        int lSum = 0, rSum = 0, maxSum = 0;
        for (int i = 0; i <= k - 1; i++) {
            lSum = lSum + arr[i];
        }
        maxSum = lSum;
        int r = arr.length - 1;
        for (int j = k - 1; j >= 0; j--) {
            lSum = lSum - arr[j];
            rSum = rSum + arr[r];
            r = r - 1;
            maxSum = Math.max(maxSum, lSum + rSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 2, 3, 4, 7, 2, 1, 7, 1};

        System.out.println(solution(arr, 4));
    }
}
