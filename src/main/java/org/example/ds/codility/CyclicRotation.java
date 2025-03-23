package org.example.ds.codility;

public class CyclicRotation {
    private static int[] solution(int[] A, int k){
        if(A.length == 0 || A == null){
            return A;
        }
        int n= A.length;
        k = k%n;

        reverse(A, 0, n-1);
        reverse(A, 0, k-1);
        reverse(A, k, n-1);
        return A;
    }

    private static int[] reverse(int[] A, int left, int right){
        while(left< right){
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 8, 9, 7, 6};
        solution(arr, 3);
    }
}
