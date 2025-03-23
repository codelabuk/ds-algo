package org.example.ds.codility;

public class BinaryGap {

    private static int solution(int N) {
        String binary = Integer.toBinaryString(N);
        System.out.println("Binary value = " + binary);
        int maxGap = 0, currentGap = 0;
        boolean continueFlag = false;

        for (char c : binary.toCharArray()) {
            if (c == '1') {
                if (continueFlag) {
                    maxGap = Math.max(maxGap, currentGap);
                }
                continueFlag = true;
                currentGap = 0;
            } else if (continueFlag) {
                currentGap++;
            }
        }
        return maxGap;
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
    }
}