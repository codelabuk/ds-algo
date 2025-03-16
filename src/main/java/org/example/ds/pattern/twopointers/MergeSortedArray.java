package org.example.ds.pattern.twopointers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSortedArray {

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // Only when nums1 contains elements greater than nums2
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }

        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        List<Integer> result = Arrays.stream(merge(nums1, 3, nums2, 3)).boxed().collect(Collectors.toList());
        System.out.println(result);

        int[] nums3 = new int[]{4, 5, 6, 0, 0, 0};
        int[] nums4 = new int[]{1, 2, 3};

        List<Integer> result1 = Arrays.stream(merge(nums3, 3, nums4, 3)).boxed().collect(Collectors.toList());
        System.out.println(result1);

    }


}
