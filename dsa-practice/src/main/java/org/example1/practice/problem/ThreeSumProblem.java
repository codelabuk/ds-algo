package org.example1.practice.problem;

import java.util.*;

public class ThreeSumProblem {

    public List<List<Integer>> bruteForce(int[] alist) {
        int n = alist.length;
        Set<List<Integer>> setData = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; j < n; j++) {
                    if (alist[i] + alist[j] + alist[k] == 0) {
                        List<Integer> data = Arrays.asList(alist[i], alist[j], alist[k]);
                        Collections.sort(data);
                        setData.add(data);
                    }
                }
            }
        }
        return new ArrayList<>(setData);
    }

    
}
