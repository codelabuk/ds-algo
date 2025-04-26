package org.example1.practice.multidimarray;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class RoundRobinMatrixPQTransversal {
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
        List<Queue<Integer>> rows = new ArrayList<>();
        boolean isElementLeft;
        for (int[] row : matrix) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            for (int num : row) {
                if (num != -1) {
                    priorityQueue.add(num);
                }
            }
            if (!priorityQueue.isEmpty()) {
                rows.add(priorityQueue);
            }
        }

        System.out.println(rows);
        do {
            isElementLeft = false;
            for (Queue<Integer> row : rows) {
                if (!row.isEmpty()) {
                    result.add(row.poll());
                    isElementLeft = true;
                }
            }
        } while (isElementLeft);

        return result;
    }
}
