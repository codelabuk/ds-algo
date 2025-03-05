package org.example.ds.interview;

public class GrasshopperStairCase {

    public static int findLowestStartingStair(int[] jumps) {
        int minReached = 0;
        int currentStair = 0;

        for (int jump : jumps) {
            currentStair += jump;
            minReached = Math.min(minReached, currentStair);
        }

        /**
         * X + minReached >= 1
         * that means X >= 1- minReached
         */
        return 1 - minReached;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 3, -4, -1, 5};
        System.out.println("Lowest positive stair case ::" + findLowestStartingStair(arr));
        int[] arr1 = new int[]{1, 2, 3, 4, -4};
        System.out.println("Lowest positive stair case ::" + findLowestStartingStair(arr1));
    }

}
