package org.example.ds.pattern.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramString {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length(), k = p.length();
        if (n < k) return result;
        Map<Character, Integer> pFreq = new HashMap<>();
        Map<Character, Integer> sFreq = new HashMap<>();

        for (char c : p.toCharArray()) {
            pFreq.put(c, pFreq.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            sFreq.put(c, sFreq.getOrDefault(c,0) + 1);
            //if window size exeeds, remove left elements
            if (right - left + 1 > k) {
                char leftChar = s.charAt(left);
                if (sFreq.get(leftChar) == 1) {
                    sFreq.remove(leftChar);
                } else {
                    sFreq.put(leftChar, sFreq.get(leftChar) - 1);
                }
                left++;
            }
            if (sFreq.equals(pFreq)) {
                result.add(left);
            }

        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(" Anagram "+ findAnagrams("cbaebabacd", "abc"));
    }
}
