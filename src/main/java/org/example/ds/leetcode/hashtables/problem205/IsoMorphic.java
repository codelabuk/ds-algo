package org.example.ds.leetcode.hashtables.problem205;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * <p>
 * Output: true
 * <p>
 * Explanation:
 * <p>
 * The strings s and t can be made identical by:
 * <p>
 * Mapping 'e' to 'a'.
 * Mapping 'g' to 'd'.
 */
public class IsoMorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            if (mapST.containsKey(chS)) {
                if (mapST.get(chS) != chT) return false;
            } else {
                mapST.put(chS, chT);
            }

            if (mapTS.containsKey(chT)) {
                if (mapTS.get(chT) != chS) return false;
            } else {
                mapTS.put(chT, chS);
            }

        }
        return true;
    }

    public boolean isIsomorphicV1(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] mapS = new int[256];
        int[] mapT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            if (mapS[chS] != mapT[chT]) return false;
            mapS[chS] = i + 1;
            mapT[chT] = i + 1;
        }
        return true;
    }
}