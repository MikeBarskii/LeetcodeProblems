package com.github.barskiy.leetcode.problems.array.findallduplicatesinanarray_442;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        List<Integer> res = solve.findDuplicates(new int[]{1,2,2});
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(index + 1);
            else
                nums[index] = -nums[index];
        }

        return res;
    }
}
