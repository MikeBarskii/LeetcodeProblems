package com.github.barskiy.leetcode.problems.array.performstringshifts;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[][] shift = new int[5][2];
        shift[0] = new int[] {1,1};
        shift[1] = new int[] {1,1};
        shift[2] = new int[] {0,2};
        shift[3] = new int[] {1,3};
        shift[4] = new int[] {0,3};
        String res = solve.stringShift("abcdefg", shift);
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public String stringShift(String s, int[][] shift) {
        int start = 0;
        for (int[] swap : shift) {
            if (swap[0] == 1)
                start += swap[1];
            else
                start -= swap[1];
        }

        start %= s.length();

        if (start == 0)
            return s;

        if (start > 0)
            start = s.length() - start;
        else
            start = Math.abs(start);

        return s.substring(start) + s.substring(0, start);
    }
}