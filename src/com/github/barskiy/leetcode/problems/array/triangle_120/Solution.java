package com.github.barskiy.leetcode.problems.array.triangle_120;

import java.util.List;

public class Solution {

    public int minimumTotalDp(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> level = triangle.get(i);
            for (int j = 0; j < level.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + level.get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) return 0;

        List<Integer> prev = triangle.get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> current = triangle.get(i);
            current.set(0, current.get(0) + prev.get(0));

            for (int j = 1; j < current.size() - 1; j++) {
                int currentValue = current.get(j);
                current.set(j, Math.min(currentValue + prev.get(j - 1), currentValue + prev.get(j)));
            }

            int lastIndex = current.size() - 1;
            current.set(lastIndex, current.get(lastIndex) + prev.get(prev.size() - 1));
            prev = current;
        }

        List<Integer> lastLevel = triangle.get(triangle.size() - 1);
        Integer min = null;
        for (Integer value : lastLevel) {
            if (min == null || value < min) min = value;
        }

        return min;
    }

}
