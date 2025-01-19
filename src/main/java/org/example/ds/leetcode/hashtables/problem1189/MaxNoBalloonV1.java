package org.example.ds.leetcode.hashtables.problem1189;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class MaxNoBalloonV1 {

    public static int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for(char ch: text.toCharArray()){
            count[ch - 'a']++;
        }
        System.out.println("WHat's inside this count" + count);

        int minBalloon = Integer.MAX_VALUE;
        minBalloon = Math.min(minBalloon,count['b' - 'a']);
        minBalloon = Math.min(minBalloon,count['a' - 'a']);
        minBalloon = Math.min(minBalloon,count['l' - 'a'] /2);
        minBalloon = Math.min(minBalloon,count['o' - 'a'] /2);
        minBalloon = Math.min(minBalloon,count['n' - 'a']);

        return  minBalloon;
    }

    public static void main(String[] args) {
        String text = "nlaebolko";
        out.print("Max no. of balloons : "+ maxNumberOfBalloons(text));
    }
}
