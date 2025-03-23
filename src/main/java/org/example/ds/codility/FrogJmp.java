package org.example.ds.codility;

public class FrogJmp {

    public static int solution(int X, int Y, int D){
        return  (Y-X + D-1)/D;
    }

    public static int solution1(int X, int Y, int D){
        return  (int)Math.ceil((double)(Y-X )/D);
    }
    public static void main(String[] args) {
        System.out.println(solution(10, 85, 30));
        System.out.println(solution1(10, 85, 30));
    }
}
