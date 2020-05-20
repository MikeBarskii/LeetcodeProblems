package com.github.barskiy.leetcode.problems.math.palindromenumber_9;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        boolean res = solve.isPalindrome(1000021);
        System.out.println(res);
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        return (x == rev || x == rev / 10);
    }
}
