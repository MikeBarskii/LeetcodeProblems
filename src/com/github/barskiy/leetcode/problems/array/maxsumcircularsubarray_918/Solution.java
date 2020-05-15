package com.github.barskiy.leetcode.problems.array.maxsumcircularsubarray_918;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.maxSubarraySumCircular(new int[]{6, 9, -3});
        System.out.println(res);
    }

    public int maxSubarraySumCircular(int[] A) {
        int total = 0, maxSum = -30000, curMax = 0, minSum = 30000, curMin = 0;
        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

}
