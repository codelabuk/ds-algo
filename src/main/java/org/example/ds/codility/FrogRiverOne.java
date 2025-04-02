package org.example.ds.codility;

import java.util.HashSet;

/**
 *Find the earliest time when a frog can jump to the other side of a river.
 */
public class FrogRiverOne {
    private static int solution(int X, int[] A) {
        HashSet<Integer> positions = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            positions.add(A[i]);
            if (positions.size() == X) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A= {1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(solution(5, A));
    }
}
