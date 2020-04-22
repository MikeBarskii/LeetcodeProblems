package com.github.barskiy.leetcode.problems.array.mergesortedarray_88;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] nums1 = {1, 2, 4, 5, 6, 0};
        int[] nums2 = {3};
        solve.merge(nums1, 5, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int lastIndex = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[lastIndex] = nums1[i];
                i--;
            } else {
                nums1[lastIndex] = nums2[j];
                j--;
            }
            lastIndex--;
        }

        while (j >= 0) {
            nums1[lastIndex] = nums2[j];
            lastIndex--;
            j--;
        }
    }
}
