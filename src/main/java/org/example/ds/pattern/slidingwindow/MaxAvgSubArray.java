package org.example.ds.pattern.slidingwindow;

public class MaxAvgSubArray {
    public static double findMaxAverage(int[] nums, int k) {
        int currentSum =0;
        for(int i=0 ; i< k; i++){
            currentSum+= nums[i];
        }
        int maxSum = currentSum;
        for(int j = k; j<nums.length ; j++){
            currentSum = currentSum - nums[j-k] + nums[j];
            maxSum = Math.max(maxSum, currentSum);
        }
        return (double) maxSum/k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}
