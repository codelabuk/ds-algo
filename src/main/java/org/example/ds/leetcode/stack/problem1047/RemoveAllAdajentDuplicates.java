package org.example.ds.leetcode.stack.problem1047;

/**
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 *
 * We repeatedly make duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * Example 2:
 *
 * Input: s = "azxxzy"
 * Output: "ay"
 *
 */
public class RemoveAllAdajentDuplicates {

    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder(); // initialize the StringBuilder ( function it like Stack)
        for(char ch : s.toCharArray()){
            if(stack.length() > 0 && stack.charAt(stack.length() -1) == ch){
                stack.deleteCharAt(stack.length() -1); // pop from stack
            } else {
                stack.append(ch); // push to stack
            }

        }
        return stack.toString();
    }
}
