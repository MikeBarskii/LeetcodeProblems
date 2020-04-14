package com.github.barskiy.leetcode.problems.hashtable.foursum2_454;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
        System.out.println(res);
    }

    // Time Complexity: O(n ^ 2)
    // Space Complexity: O(n ^ 2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumToCount = new HashMap<>();

        for (int i : A) {
            for (int j : B) {
                int sum = i + j;
                sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int i : C) {
            for (int j : D) {
                int sum = - (i + j);
                res += sumToCount.getOrDefault(sum, 0);
            }
        }

        return res;
    }
}
