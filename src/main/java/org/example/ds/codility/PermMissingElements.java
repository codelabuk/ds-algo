package org.example.ds.codility;

import java.util.Arrays;

public class PermMissingElements {

    public static int solution(int[] A) {
        Arrays.sort(A);
        if (A.length == 0 || A[0] != 1){
            return 1;
        }

        for(int i =0 ;i< A.length- 1;i++){
            if(A[i] +1 != A[i+1]){
                return A[i] +1;
            }
        }
        return A[A.length -1] +1;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2,3,1,5};
        System.out.println(" Result = "+ solution(A));
    }
}
