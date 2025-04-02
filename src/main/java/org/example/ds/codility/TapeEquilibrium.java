package org.example.ds.codility;

import java.util.ArrayList;
import java.util.List;

public class TapeEquilibrium {

    public int solution(int[] A) {
        int maxSum= 0, currSum =0, remSum= 0;
        int minDiff = 0;
        List<Integer> minDiffList = new ArrayList();
        for(int a: A){
            maxSum += a;
        }

        for(int i =0 ; i< A.length; i++){
            currSum += A[i];
            remSum = Math.abs(maxSum - currSum);
            minDiff= Math.abs(currSum - remSum);
            minDiffList.add(minDiff);
        }

        return minDiffList.stream().min(Integer::compareTo).get();
    }



    public int solutionOptimal(int[] A) {
        int maxSum= 0;
        for(int a: A){
            maxSum += a;
        }
        int leftSum =0, rightSum = maxSum;
        int minDIfference =  Integer.MAX_VALUE;

        for(int i =0 ; i< A.length; i++){
            leftSum += A[i];
            rightSum -= A[i];
            int differenece= Math.abs(leftSum - rightSum);
            minDIfference = Math.min(minDIfference, differenece);
        }

        return minDIfference;
    }



}
