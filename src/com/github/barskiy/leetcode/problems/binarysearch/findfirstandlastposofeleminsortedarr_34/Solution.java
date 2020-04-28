package com.github.barskiy.leetcode.problems.binarysearch.findfirstandlastposofeleminsortedarr_34;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] res = solve.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(Arrays.toString(res));
    }

    // Time Complexity: O(log(n))
    // Space Complexity: O(1)
    public int[] searchRangeOptimized(int[] nums, int target) {
        int[] res = new int[]{-1, -1};

        res[0] = getStartingIndex(nums, target);
        res[1] = (res[0] == -1) ? -1 : getEndingIndex(nums, target);

        return res;
    }

    private int getStartingIndex(int[] nums, int target) {
        int index = -1;

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= target) end = mid - 1;
            else start = mid + 1;

            if (nums[mid] == target) index = mid;
        }

        return index;
    }

    private int getEndingIndex(int[] nums, int target) {
        int index = -1;

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target)
                start = mid + 1;
            else
                end = mid - 1;

            if (nums[mid] == target) index = mid;
        }

        return index;
    }

    // Time Complexity: O(log(n))
    // Space Complexity: O(log(n))
    public int[] searchRange(int[] nums, int target) {
        getRangeOfFirstAndLastPosOfTarget(nums, target, 0, nums.length - 1);
        if (first == null)
            return new int[]{-1, -1};
        else
            return new int[]{first, last};
    }

    Integer first = null;
    Integer last = null;

    private void getRangeOfFirstAndLastPosOfTarget(int[] nums, int target, int left, int right) {
        if (left > right)
            return;

        int mid = (left + right) / 2;
        if (target < nums[mid]) {
            getRangeOfFirstAndLastPosOfTarget(nums, target, left, mid - 1);
        } else if (target > nums[mid])
            getRangeOfFirstAndLastPosOfTarget(nums, target, mid + 1, right);
        else {
            first = (first == null) ? mid : Math.min(first, mid);
            last = (last == null) ? mid : Math.max(last, mid);
            getRangeOfFirstAndLastPosOfTarget(nums, target, left, mid - 1);
            getRangeOfFirstAndLastPosOfTarget(nums, target, mid + 1, right);
        }
    }
}
