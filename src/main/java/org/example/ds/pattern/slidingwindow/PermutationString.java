package org.example.ds.pattern.slidingwindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationString {
    public static boolean checkInclusion(String s1, String s2) {
        boolean checkInclusion = false;
        int k = s1.length(), n = s2.length();
        if (k > n) return false;
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        for (Character ch : s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        for (int right = 0; right < n; right++) {
            char c = s2.charAt(right);
            s2Map.put(c, s2Map.getOrDefault(c, 0) + 1);
            if (right - left + 1 > k) {
                char leftChar = s2.charAt(left);
                if (s2Map.get(leftChar) == 1) {
                    s2Map.remove(leftChar);
                } else {
                    s2Map.put(leftChar, s2Map.get(leftChar) - 1);
                }
                left++;
            }

            if (s2Map.equals(s1Map)) {
                checkInclusion = true;
            }
        }
        return checkInclusion;

    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("adc", "dcda"));
    }
}
