package com.github.barskiy.leetcode.problems.array.singlenumber_136;

public class Solution {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) res ^= num;

        return res;
    }
}
