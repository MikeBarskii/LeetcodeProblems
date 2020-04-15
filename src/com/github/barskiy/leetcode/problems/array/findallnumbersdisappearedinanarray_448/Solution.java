package com.github.barskiy.leetcode.problems.array.findallnumbersdisappearedinanarray_448;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solve = new Solution();
        List<Integer> res = solve.findDisappearedNumbersOptimized(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(res);
    }

    public List<Integer> findDisappearedNumbersOptimized(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0)
                nums[index] = -nums[index];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                res.add(i + 1);
        }

        return res;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> values = new HashSet<Integer>();
        for(int i = 1; i <= nums.length; i++) {
            values.add(i);
        }

        for(int num: nums) {
            values.remove(num);
        }

        return new ArrayList<>(values);
    }
}
