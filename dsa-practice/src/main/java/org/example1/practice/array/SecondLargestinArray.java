package org.example1.practice.array;

public class SecondLargestinArray {

    static int solution(int[] arr) {
        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        int secondLargest = -1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    static int secondLargest(int[] arr, int n) {
        int largest = arr[0];
        int secondLargest = -1;
        for (int i = 1; i <= n - 1; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    static int secondSmallest(int[] arr, int n){
        int smallest = arr[0];
        int secondSmallest = Integer.MAX_VALUE;

        for(int i =0; i < n ; i++){
            if(arr[i] < smallest){
                secondSmallest = smallest;
                smallest = arr[i];
            } else if(arr[i] != smallest && arr[i] < secondSmallest){
                secondSmallest = arr[i];
            }

        }
        return secondSmallest;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 7, 7, 5};
        System.out.println(solution(arr));
        System.out.println(secondLargest(arr, arr.length));
        System.out.println(secondSmallest(arr, arr.length));
    }
}
