package org.example.ds.leetcode.hashtables.problem1189;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.*;

public class MaxNoBalloon {

    public static int maxNumberOfBalloons(String text) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch : text.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) +1);
        }
        String balloon = "balloon";
        int maxBalloons = Integer.MAX_VALUE;
        Map<Character, Integer> freqBalloons = new HashMap<>();
        for(char c: balloon.toCharArray()){
            freqBalloons.put(c, freqBalloons.getOrDefault(c,0) +1);
        }
        for(Map.Entry<Character, Integer> bal: freqBalloons.entrySet()){
            char key = bal.getKey();
            int count = bal.getValue();
            maxBalloons = Math.min(maxBalloons, freqMap.getOrDefault(key, 0)/count);
        }
        return  maxBalloons;
    }

    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        out.print("Max no. of balloons : "+ maxNumberOfBalloons(text));
    }
}
