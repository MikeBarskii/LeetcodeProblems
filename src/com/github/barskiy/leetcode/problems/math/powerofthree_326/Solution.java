package com.github.barskiy.leetcode.problems.math.powerofthree_326;

public class Solution {

    // https://leetcode.com/articles/power-of-three/
    public boolean isPowerOfThree(int n) {
        // 1162261467 = 3 ^ 19
        return n > 0 && 1162261467 % n == 0;
    }

    public boolean isPowerOfThreeLoop(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
