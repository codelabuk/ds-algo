package org.example1.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionTwoSortedArray {

    static List<Integer> solution(List<Integer> firstArray, List<Integer> secondArray) {
        int n1 = firstArray.size();
        int n2 = secondArray.size();
        int i = 0, j = 0;
        List<Integer> unionArray = new ArrayList<>();

        while (i < n1 && j < n2) {
            if (firstArray.get(i) <= secondArray.get(j)) {
                if (unionArray.size() == 0 || !unionArray.contains(firstArray.get(i))) {
                    unionArray.add(firstArray.get(i));
                }
                i++;
            } else {
                if (unionArray.size() == 0 || !unionArray.contains(secondArray.get(j))) {
                    unionArray.add(secondArray.get(j));
                }
                j++;
            }
        }

        while (i < n1) {
            if (unionArray.size() == 0 || !unionArray.contains(firstArray.get(i))) {
                unionArray.add(firstArray.get(i));
            }
            i++;
        }

        while (j < n2) {
            if (unionArray.size() == 0 || !unionArray.contains(secondArray.get(j))) {
                unionArray.add(secondArray.get(j));
            }
            j++;
        }
        return unionArray;

    }

    public static void main(String[] args) {
        List<Integer> firstArray = Arrays.asList(1, 1, 2, 3, 4, 5);
        List<Integer> secondArray = Arrays.asList(2, 3, 4, 4, 5, 6);

        System.out.println(solution(firstArray,secondArray));

    }
}
