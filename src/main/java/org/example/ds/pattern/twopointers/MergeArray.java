package org.example.ds.pattern.twopointers;

import java.util.Arrays;

public class MergeArray {

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2= {2,5,6};
        int m =3, n=3;
        int[] result = merge(nums1, m, nums2, n);

        for(int res : result) {
            System.out.print(res+",");
        }
        System.out.println();

    }

}
