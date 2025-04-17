package org.example1.practice.twopointer;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasketSol {

    static int solution(int[] arr, int k) {
        int l = 0, r = 0, n = arr.length;
        int maxLen = 0;
        Map<Integer, Integer> fruitMap = new HashMap<>();
        while (r < n) {
            fruitMap.put(arr[r], fruitMap.getOrDefault(arr[r], 0) + 1);
            if (fruitMap.size() > k) {
                int keyVal = fruitMap.get(arr[l]);
                keyVal--;
                fruitMap.put(arr[l], keyVal);
                if (fruitMap.get(arr[l]) == 0) {
                    fruitMap.remove(arr[l]);
                }
                l++;
            }
            if (fruitMap.size() <= k) {
                maxLen= Math.max(maxLen, r -l+ 1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println("Maxium consecutive "+ solution(arr ,2));

    }
}
