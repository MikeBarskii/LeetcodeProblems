package com.github.barskiy.leetcode.problems.binarysearch.searchinsertposition_35;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();

        int res = solve.searchInsert(new int[]{1, 3, 5, 6}, 0);
        System.out.println(res);
    }


    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return low;
    }
}
