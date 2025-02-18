package org.example.ds.leetcode.arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return -1;

        int i = 0;
        for(int j = 1; j< nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 2, 3};
        System.out.println("Return no.  "+ removeDuplicates(nums));
    }

}
