package org.example.ds.algo;
// Find the element in array
public class LinearSearch {
    // TIme Complexity - O(n)
    public int linearSearch(int[] array, int target){
        for(int i=0; i< array.length ; i++){
            if(array[i] == target){
                return i;
            }
        }
        return  -1;
    }
}
