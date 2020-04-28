package com.github.barskiy.leetcode.problems.recursion.fibonaccinumber_509;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.fibOptimal(6);
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int fibOptimal(int N) {
        int[] values = new int[]{0, 1};
        for (int i = 2; i <= N; i++) {
            values[i % 2] = values[0] + values[1];
        }

        return values[N % 2];
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    Map<Integer, Integer> indexToValue = new HashMap<>();
    public int fibMemoization(int N) {
        if (indexToValue.containsKey(N)) return indexToValue.get(N);
        int res;
        if (N < 2) res = 1;
        else res = fibMemoization(N - 1) + fibMemoization(N - 2);
        indexToValue.put(N, res);
        return res;
    }

    // Time Complexity: O(2^n)
    // Space Complexity: O(n)
    public int fibRecursive(int N) {
        if (N < 2) return 1;
        return fibRecursive(N - 1) + fibRecursive(N - 2);
    }
}
