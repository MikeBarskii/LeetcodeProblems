package com.github.barskiy.leetcode.problems.math.maximum69number_1323;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.maximum69Number(6669);
        System.out.println(res);
    }

    public int maximum69Number (int num) {
        if (num == 9999) return num;

        for (int i = 1000; i > 0; i /= 10) {
            int leftNumber = num / i % 10;
            if (leftNumber == 6)
                return num - 6 * i + 9 * i;
        }

        return num;
    }

}
