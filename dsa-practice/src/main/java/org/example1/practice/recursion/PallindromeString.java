package org.example1.practice.recursion;

public class PallindromeString {

    static boolean isPallindrome(char[] chStr, int i, int n) {
        if (i >= n / 2) {
            return true;
        }
        if (chStr[i] != chStr[n - i - 1]) {
            return false;
        }
        return isPallindrome(chStr, i + 1, n);
    }

    public static void main(String[] args) {
        String str = "madamap";
        int n = str.length();
        int i = 0;

        System.out.println("Check if it's pallindrome: "+ isPallindrome(str.toCharArray(), i, n));
    }
}
