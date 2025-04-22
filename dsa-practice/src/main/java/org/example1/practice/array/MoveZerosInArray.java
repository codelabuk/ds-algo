package org.example1.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZerosInArray {

    public static void main(String[] args) {
        int[] arr= new int[]{1,0,2,3,2,0,0,4,5,6};
        int[] arr1= new int[]{1,0,2,3,2,0,0,4,5,6};
        System.out.println(Arrays.toString(bruteForceSol(arr)));
        System.out.println(Arrays.toString(optimalSol(arr1)));
    }

    static int[] bruteForceSol(int[] arr){
        int n = arr.length;
        List<Integer> temp = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(arr[i] != 0){
                temp.add(arr[i]);
            }
        }

        for(int i = 0; i< temp.size(); i++){
            arr[i] = temp.get(i);
        }

        for(int j = temp.size() ; j < n; j++){
            arr[j] = 0;
        }
        return arr;
    }


    static int[] optimalSol(int[] arr){
        int n = arr.length;
        int j = -1;

        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }

        if(j == -1) return arr;

        for(int i = j+1; i < n; i++){
            if(arr[i] != 0){
                swap(arr, i, j);
                j++;
            }
        }

        return arr;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }


}
