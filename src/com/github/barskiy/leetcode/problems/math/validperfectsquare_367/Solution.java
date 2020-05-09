package com.github.barskiy.leetcode.problems.math.validperfectsquare_367;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        boolean res = solve.isPerfectSquare(4);
        System.out.println(res);
    }


    public boolean isPerfectSquare(int num) {
        long left = 1, right = num / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) return true;
            else if (mid * mid < num)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }

    public boolean isPerfectSquareWithoutLong(int num) {
        if (num == 1) return true;

        int left = 1, right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = num / mid, remain = num % mid;
            if (res == mid && remain == 0) return true;
            else if (res > mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    public boolean isPerfectSquareInefficient(int num) {
        int squareValue = 1;
        for (int i = 3; squareValue < num; i += 2) {
            squareValue += i;
        }
        return squareValue == num;
    }
}
