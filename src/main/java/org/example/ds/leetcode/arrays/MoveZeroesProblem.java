package org.example.ds.leetcode.arrays;

/**
 * Arrays problem
 */
public class MoveZeroesProblem {

    public static void moveZeroes(int[] nums) {
        int insertPos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[insertPos];
                nums[insertPos] = nums[i];
                nums[i] = temp;
                insertPos++;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            System.out.print(nums[k] + ",");
        }


    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }
}
