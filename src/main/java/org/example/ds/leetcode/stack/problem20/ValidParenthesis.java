package org.example.ds.leetcode.stack.problem20;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 *
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 *
 * Output: false
 *
 * Example 4:
 *
 * Input: s = "([])"
 *
 * Output: true
 */
public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> valStack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c== '(' || c == '{' || c == '['){
                valStack.push(c);
            } else {
                if(valStack.isEmpty()) return false;
                char top = valStack.pop(); //
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return  valStack.isEmpty();
    }
}
