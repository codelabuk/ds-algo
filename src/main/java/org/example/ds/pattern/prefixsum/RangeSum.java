package org.example.ds.pattern.prefixsum;

public class RangeSum {
    private int[] prefixSum;

    public RangeSum(int[] nums) {
        this.prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }

    public static void main(String[] args) {
        int[] arrr = {-2, 0, 3, -5, 2, -1};
        RangeSum numArray = new RangeSum(arrr);
        System.out.println(numArray.sumRange(0, 2)); // return (-2) + 0 + 3 = 1
        System.out.println(numArray.sumRange(2, 5)); // return 3 + (-5) + 2 + (-1) = -1
        System.out.println(numArray.sumRange(0, 5));
    }
}
