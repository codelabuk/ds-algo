package org.example.ds.interview;

import java.util.LinkedList;
import java.util.Stack;

public class ReversebyStack {
    private static int reverse(int n, int[] arr) {
        int left = 0, right = arr.length - 1;
        int result = 0;
        LinkedList<Integer> list = new LinkedList<>();
        while (left < right) {
            list.addLast(arr[left]);
            list.addLast(arr[right]);
            left++;
            right--;
        }
        if (left == right) {
            list.addLast(arr[right]);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            result = result * 10 + list.get(i);
        }
        System.out.println(list);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6, 9};
        System.out.println("Result = " + reverse(5, arr));
    }
}
