package com.github.barskiy.leetcode.problems.array.shortestunsortedcontinuoussubarray_581;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.findUnsortedSubarray(new int[]{1,3,3,2,2,4});
        System.out.println(res);
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] sortedArray = nums.clone();
        Arrays.sort(sortedArray);
        int start = -1, end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sortedArray[i])
                if (start == -1) start = i;
                else end = i + 1;
        }
        return (start == -1) ? 0 : end - start;
    }
}
