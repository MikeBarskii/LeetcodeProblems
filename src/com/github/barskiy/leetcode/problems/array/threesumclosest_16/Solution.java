package com.github.barskiy.leetcode.problems.array.threesumclosest_16;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.threeSumClosest(new int[] {-1, 2, 1, -4}, 1);
        System.out.println(res);
    }

    public int threeSumClosest(int[] nums, int target) {
        Set<Integer> diffs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = target - (i + j);
                diffs.add(diff);
            }
        }
        //TODO
        return 1;
    }
}
