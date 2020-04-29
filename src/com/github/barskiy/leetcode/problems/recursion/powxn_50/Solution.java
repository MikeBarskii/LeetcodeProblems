package com.github.barskiy.leetcode.problems.recursion.powxn_50;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        double res = solve.myPow(2, -5);
        System.out.println(res);
    }

    // Time Complexity: O(log(n))
    // Space Complexity: O(log(n))
    public double myPow(double x, int n) {
        if (n == 0) return 1;

        double partial = myPow(x, n / 2);
        double result = partial * partial;
        if (n % 2 != 0)
            result *= ((n > 0) ? x : 1 / x);
        return result;
    }

}
