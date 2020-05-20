package com.github.barskiy.leetcode.problems.binarysearch.findmininrotatedsortedarray_153;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.findMin(new int[]{5,1,2,3,4});
        System.out.println(res);
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end])
                start = mid + 1;
            else
                end = mid;
        }

        return nums[start];
    }
}
