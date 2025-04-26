package org.example1.practice.multidimarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundRobinMatrixTransversal {

    public static void main(String[] args) {
        int[][] matrix = {
                {5, -1, 7, 9},
                {-1, 1, 3, -1},
                {-1, 6, -1, 8}
        };

        System.out.println(solution(matrix));

    }

    static List<Integer> solution(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        boolean isElementLeft;

        List<List<Integer>> rows = new ArrayList<>();
        for (int[] row : matrix) {
            List<Integer> list = new ArrayList<>();
            for (int num : row) {
                if (num != -1) {
                    list.add(num);
                }
            }
            if (!list.isEmpty()) {
                Collections.sort(list);
                rows.add(list);
            }
        }

        do {
            isElementLeft = false;
            for (List<Integer> row : rows) {
                if (!row.isEmpty()) {
                    result.add(row.remove(0));
                    isElementLeft = true;
                }
            }
        } while (isElementLeft);

        return result;

    }
}
