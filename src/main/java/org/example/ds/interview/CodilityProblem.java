package org.example.ds.interview;

import java.util.Arrays;

public class CodilityProblem {

    private static int solution(int[] A){
        Arrays.sort(A);
        int min = 1;

        for(int i :A){
            if(i == min){
                min++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,-3};
        System.out.println(solution(arr));
    }

}
