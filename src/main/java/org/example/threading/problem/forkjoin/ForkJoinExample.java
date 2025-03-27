package org.example.threading.problem.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Integer> {
    private final int[] arr;
    private final int start, end;
    private static final int THRESHOLD = 3;

    public SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if ((end - start) < THRESHOLD) {
            int sum =0;
            for(int i = start ; i< end; i++){
                sum += arr[i];
            }
            return sum;
        }
        int mid = (start+end)/2;
        SumTask leftTask = new SumTask(arr,start, mid);
        SumTask rightTask = new SumTask(arr, mid, end);
        leftTask.fork();
        int rightResult = rightTask.compute();
        int leftResult = leftTask.join();

        return rightResult+ leftResult;
    }
}

public class ForkJoinExample {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9};

        ForkJoinPool pool = new ForkJoinPool();
        SumTask sumTask = new SumTask(numbers, 0, numbers.length);
        int result = pool.invoke(sumTask);
        System.out.println("Total Sum:" + result);

    }
}
