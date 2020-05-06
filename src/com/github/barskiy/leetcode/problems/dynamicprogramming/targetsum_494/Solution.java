package com.github.barskiy.leetcode.problems.dynamicprogramming.targetsum_494;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.findTargetSumWays(new int[]{1}, 1);
        System.out.println(res);
    }

    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer, Integer> visitedToCount = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(nums[0]);
        queue.offer(-nums[0]);
        visitedToCount.put(nums[0], 1);
        visitedToCount.put(-nums[0], 1);

        for (int i = 1; i <= nums.length - 1; i++) {
            Map<Integer, Integer> currentVisited = new HashMap<>();
            int size = queue.size();
            while (size > 0) {
                int sum = queue.remove();

                int negative = sum - nums[i];
                int seenInLevel = currentVisited.getOrDefault(negative, 0);
                if (seenInLevel == 0) queue.offer(negative);
                int seenNegativeTotal = visitedToCount.get(sum) + seenInLevel;
                currentVisited.put(negative, seenNegativeTotal);

                int positive = sum + nums[i];
                seenInLevel = currentVisited.getOrDefault(positive, 0);
                if (seenInLevel == 0) queue.offer(positive);
                int seenPositiveTotal = visitedToCount.get(sum) + seenInLevel;
                currentVisited.put(positive, seenPositiveTotal);

                size--;
            }
            visitedToCount = currentVisited;
        }

        return visitedToCount.getOrDefault(S, 0);
    }

}
