package org.example.ds.leetcode.stack.problem155;

import java.util.Stack;

public class MinStackV1 {
    private Stack<Integer> stack;
    private int min;
    public MinStackV1() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            min = val;
        } else {
            if(min>= val){
                stack.push(min); // push the current min to stack before this new min
                min = val;
            }
        }
        stack.push(val); // push the value to stack

    }

    public void pop() {
        // if we pop the min value , pop another value from min stack
        if(!stack.isEmpty() && min == stack.pop()) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
