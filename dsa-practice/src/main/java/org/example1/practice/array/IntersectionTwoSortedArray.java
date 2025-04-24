package org.example1.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionTwoSortedArray {

    static List<Integer> solution(List<Integer> firstArray, List<Integer> secondArray) {
        int n1 = firstArray.size();
        int n2 = secondArray.size();
        int i = 0, j = 0;
        List<Integer> intersectionArray = new ArrayList<>();

        while (i < n1 && j < n2) {
            if (firstArray.get(i) < secondArray.get(j)) {
                i++;
            } else if (secondArray.get(j) < firstArray.get(i)){
                j++;
            } else{
                intersectionArray.add(firstArray.get(i));
                i++;
                j++;
            }
        }

        return intersectionArray;

    }

    public static void main(String[] args) {
        List<Integer> firstArray = Arrays.asList(1, 1, 2, 3, 4, 5);
        List<Integer> secondArray = Arrays.asList(2, 3, 4, 4, 5, 6);

        System.out.println(solution(firstArray,secondArray));

    }
}
