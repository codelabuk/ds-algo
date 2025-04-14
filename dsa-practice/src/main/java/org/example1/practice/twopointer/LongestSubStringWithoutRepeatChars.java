package org.example1.practice.twopointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatChars {

    static int solution(String s) {
        int l = 0, r = 0, n = s.length();
        int maxlen = 0, len = 0;
        Map<Character, Integer> cMap = new HashMap<>();
        while (r < n) {
            if (cMap.containsKey(s.charAt(r))) {
                if (cMap.get(s.charAt(r)) >= l) {
                    l = cMap.get(s.charAt(r)) + 1;
                }
            }
            cMap.put(s.charAt(r), r);
            len = r - l + 1;
            maxlen = Math.max(maxlen, len);
            r++;
        }
        return maxlen;

    }

    public static void main(String[] args) {
        String s = "cadbzabcd";
        System.out.println("maxlenth = " + solution(s));
        String s1 = "abcabcdefab";
        System.out.println("maxlenth = " + solution(s1));

        String s2 = "cadbzabcdefghi";
        System.out.println("maxlenth = " + solution(s2));
    }
}
