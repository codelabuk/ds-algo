package org.example.ds.leetcode.heaps.problem1642;

import java.util.PriorityQueue;

public class SolutionFarthestBuilding {
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) { // only consider building of height greater than current building
                pq.add(diff);
                if (pq.size() > ladders) {  //
                    bricks -= pq.poll(); // use bricks
                }
                if (bricks < 0) { // bricks no more available
                    System.out.println("bricks no more available");
                    return i;
                }
            }
        }
        return heights.length - 1;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{4,2,7,6,9,14,12};
        int bricks = 5, ladder =1 ;
        System.out.println(" Building we can reach furthest: "+ furthestBuilding(heights, bricks, ladder));
    }
}
