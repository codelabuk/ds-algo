package org.example.ds.leetcode.stack.problem1047;

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
