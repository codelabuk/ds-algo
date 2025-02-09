package org.example.ds.leetcode.string.problem14;

public class LongestCommonPrefixV1 {
    public static String byHorizontalScanning(String[] str) {
        if (str == null || str.length == 0) return "";
        String prefix = str[0];
        for (int i = 0; i < str.length; i++) {
            while (str[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static String byVerticalScanning(String[] str) {
        if (str == null || str.length == 0) return "";
        for (int i = 0; i < str[0].length(); i++) {
            char c = str[0].charAt(i);
            for (int j = 1; j < str.length; j++) {
                if(i == str[j].length() || str[j].charAt(i) !=c){
                    return str[0].substring(0, i);
                }
            }
        }
        return str[0];
    }

    public static void main(String[] args) {
        String[] str = new String[]{"flower", "flow", "flight"};
        System.out.println("Longest Prefix: " + byHorizontalScanning(str));
    }
}
