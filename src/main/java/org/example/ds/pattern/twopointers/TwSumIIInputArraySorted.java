package org.example.ds.pattern.twopointers;

public class TwSumIIInputArraySorted {

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }else if(sum < target){
                left++;
            } else{
                right--;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        int target =9;
        System.out.println("Two sum : "+ twoSum(numbers, target));
    }
}
