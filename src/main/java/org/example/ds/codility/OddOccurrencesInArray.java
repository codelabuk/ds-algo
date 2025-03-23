package org.example.ds.codility;

public class OddOccurrencesInArray {
    public static int solution(int[] A) {
        int result = 0;
        for(int a: A){
            result ^=a;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,3,9,3,9,7,9};
        System.out.println(solution(arr));
    }
}
