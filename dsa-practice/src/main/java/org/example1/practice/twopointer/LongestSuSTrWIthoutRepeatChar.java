package org.example1.practice.twopointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSuSTrWIthoutRepeatChar {

    static int solution(String str) {
        int l = 0, r = 0;
        int n = str.length();
        int maxLen = 0;
        Map<Character, Integer> cMap = new HashMap<>();
        while (r < n) {
            if (cMap.containsKey(str.charAt(r))) {
                if (cMap.get(str.charAt(r)) >= 1) {
                    l = cMap.get(str.charAt(r)) + 1;
                }
            }
            cMap.put(str.charAt(r), r);
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }

    static String findString(String str) {
        int l = 0, r = 0;
        int n = str.length();
        int maxLen = 0;
        int start = 0;
        Map<Character, Integer> cMap = new HashMap<>();
        while (r < n) {
            Character ch = str.charAt(r);
            if (cMap.containsKey(ch) && cMap.get(ch) >= 1) {
                l = cMap.get(ch) + 1;
            }

            cMap.put(ch, r);
            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
                start = l;
            }
            r++;
        }


        return str.substring(start,  start + maxLen);
    }

    public static void main(String[] args) {
        String s = "abcabcbb"; //abc
        System.out.println(solution(s));
        System.out.println(findString(s));


        String s0 = "abcdeabcefghibb";// abcefghi
        System.out.println(solution(s0));
        System.out.println(findString(s0));


    }
}
