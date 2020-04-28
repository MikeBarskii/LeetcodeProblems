package com.github.barskiy.leetcode.problems.dynamicprogramming.climbingstairs_70;

public class Solution {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int climbStairs(int n) {
        // Fibonacci
        int first = 1, second = 2;

        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    int[] stairToSteps;

    public int climbStairsRecursivelyWithMemoization(int n) {
        stairToSteps = new int[n + 1];
        stairToSteps[0] = 1;
        stairToSteps[1] = 2;
        climbStairsHelper(n);
        return stairToSteps[n];
    }

    private int climbStairsHelper(int n) {
        if (stairToSteps[n] != 0) return stairToSteps[n];

        int res = climbStairsHelper(n - 1) + climbStairsHelper(n - 2);
        stairToSteps[n] = res;
        return res;
    }

    // Time Complexity: O(2^n)
    // Space Complexity: O(n)
    public int climbStairsRecursively(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairsRecursively(n - 1) + climbStairsRecursively(n - 2);
    }
}
