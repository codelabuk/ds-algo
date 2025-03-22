package org.example.ds.pattern.prefixsum.test;

public class RangeSum {
    private int[] prefixArr;

    public RangeSum(int[] nums) {
        prefixArr = new int[nums.length +1];
        for(int i = 0; i < nums.length; i++){
            prefixArr[i+1] = prefixArr[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixArr[right+1] - prefixArr[left];
    }

    public static void main(String[] args) {
        int[] arrr = {-2, 0, 3, -5, 2, -1};
        RangeSum numArray = new RangeSum(arrr);
        System.out.println(numArray.sumRange(0, 2)); // return (-2) + 0 + 3 = 1
        //System.out.println(numArray.sumRange(2, 5)); // return 3 + (-5) + 2 + (-1) = -1
        // System.out.println(numArray.sumRange(0, 5));
    }
}
