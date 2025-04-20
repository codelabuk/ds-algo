package org.example1.practice.stacknqueue;

import java.util.Stack;

public class BalanacedParanthesis {

    static boolean solution(String s) {
        int n = s.length();
        Stack<Character> stackChar = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stackChar.push(s.charAt(i));
            } else {
                if(s.isEmpty()) return  false;
                char ch = stackChar.peek();
                stackChar.pop();
                if(s.charAt(i) == ')' && ch  != '(') return  false;
                if(s.charAt(i) == '}' && ch  != '{') return  false;
                if(s.charAt(i) == ']' && ch  != '[') return  false;
            }
        }
        return stackChar.isEmpty();

    }

    public static void main(String[] args) {
        String str = "()[{}()]";
        System.out.println(solution(str));
        String str1 = "()[{}(])";
        System.out.println(solution(str1));

    }
}
