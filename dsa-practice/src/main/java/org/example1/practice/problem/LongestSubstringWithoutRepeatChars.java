package org.example1.practice.problem;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatChars {

    /**
     * Optimal approach
     * @param str
     * @return
     */
    private static Map<String, Integer> getLongestSubstring(String str) {
        int l = 0, r = 0;
        int maxLen = 0, n = str.length();
        int start = 0;
        Map<Character, Integer> cMap = new HashMap<>();
        Map<String, Integer> cMapKeys = new HashMap<>();
        while (r < n) {
            if (cMap.containsKey(str.charAt(r))) {
                l = cMap.get(str.charAt(r)) + 1;
            }

            cMap.put(str.charAt(r), r);
            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
                start = l;
            }
            r++;
        }
        cMapKeys.put(str.substring(start, start + maxLen), maxLen);

        return cMapKeys;
    }

    /**
     * bruteforce Approach
     *
     * @param str
     */
    private static Integer getLongestSubStr(String str) {
        int n = str.length();
        int maxLen = 0;
        Map<Character, Integer> cMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (cMap.containsKey(str.charAt(j))) {
                    break;
                }
                maxLen = Math.max(maxLen, j - i + 1);
                cMap.put(str.charAt(j), j);
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        String s = "abcabcbb"; //abc
        System.out.println(getLongestSubStr(s));
        System.out.println(getLongestSubstring(s));

        String s0 = "abcdeabcefghibb";// abcefghi
        System.out.println(getLongestSubStr(s0));
        System.out.println(getLongestSubstring(s0));
    }
}
