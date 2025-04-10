package org.example.ds.codility.prefixsum;

public class PassingCars {

    public static int solution(int[] A) {
        int eastCars = 0;
        int passingCars = 0;

        for (int a : A) {
            if (a == 0) {
                eastCars++;
            } else {
                passingCars += eastCars;
                if (passingCars > 1_000_000_000) return -1;
            }
        }
        return passingCars;
    }

    public static void main(String[] args) {
        int[] A = new int[]{0,1,0,1,1};
        System.out.println(solution(A));
    }
}

