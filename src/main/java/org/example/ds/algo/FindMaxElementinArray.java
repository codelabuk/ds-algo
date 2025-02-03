package org.example.ds.algo;
// Unsorted Array , fix max - O(n) - Linear time
public class FindMaxElementinArray {

    public int findMax(int[] array){
        int  max = array[0];
        for (int i = 1; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        return  max;
    }
}
