package com.github.barskiy.leetcode.problems.dynamicprogramming.perfectsquares_279;

import java.util.*;

public class Solution {

    public int numSquaresDf(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);

            if (sqrt * sqrt == i) {
                dp[i] = 1;
                continue;
            }

            for (int j = 1; j <= sqrt; j++) {
                int diff = i - j * j;
                dp[i] = Math.min(dp[i], dp[diff] + 1);
            }
        }
        return dp[n];
    }

    public int numSquaresBfs(int n) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while (size > 0) {
                Integer num = queue.poll();

                int closedSqrt = (int) Math.sqrt(num);
                for (int i = closedSqrt; i >= 1; i--) {
                    int diff = num - (i * i);

                    if (diff == 0) return level;

                    if (visited.add(diff)) queue.offer(diff);
                }

                size--;
            }
            level++;
        }
        return level;
    }
}
