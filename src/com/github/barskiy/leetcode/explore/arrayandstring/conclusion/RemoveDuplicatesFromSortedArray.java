package com.github.barskiy.leetcode.explore.arrayandstring.conclusion;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int prev = nums[0];
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                prev = nums[i];
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
