package org.example1.practice.array;

public class LargestNumber {

    static int solution(int[] arr) {
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 5, 2, 7};
        System.out.println(solution(arr));
    }

}
