package org.example.ds.codility;

public class MaxCounters {

    public static int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max=0, lastUpdate=0;

        for(int i = 0; i <N; i++){
            int X = A[i];
            if(X>= 1 && X<= N){
                if(counters[X-1] < lastUpdate){
                    counters[X-1] = lastUpdate;
                }
                counters[X-1]++;
                if(counters[X-1]> max){
                    max = counters[X-1];
                }
            } else if(X == N+1){
                lastUpdate = max;
            }
        }
        for(int j = 0; j< N; j++){
            if(counters[j] < lastUpdate){
                counters[j] = lastUpdate;
            }
        }
        return  counters;
    }
    public static void main(String[] args) {
        int[] A = new int[]{3,4,4,6,1,4,4};
        int[] result= solution(5,A);
        System.out.println(result);
    }
}
