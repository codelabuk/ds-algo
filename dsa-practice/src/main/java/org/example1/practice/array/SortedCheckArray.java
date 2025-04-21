package org.example1.practice.array;

public class SortedCheckArray {

    static boolean isSorted(int[] arr){

        for(int i= 1; i < arr.length ; i++){
            if(arr[i] >= arr[i-1]){
            } else {
                return  false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,3,4,5,8};
        int[] arr2 = new int[]{1,3,3,2,5,8};
        System.out.println(isSorted(arr1));
        System.out.println(isSorted(arr2));
    }
}
