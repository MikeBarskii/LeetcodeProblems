package com.github.barskiy.leetcode.problems.array.plusone_66;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] res = solve.plusOne(new int[]{4});
        System.out.println(Arrays.toString(res));
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }

            digits[i] = 0;
        }

        if (digits[0] == 0) {
           int[] newDigits = new int[digits.length + 1];
           newDigits[0] = 1;
           return newDigits;
        } else
            return digits;

    }
}