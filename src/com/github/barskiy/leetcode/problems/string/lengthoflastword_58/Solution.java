package com.github.barskiy.leetcode.problems.string.lengthoflastword_58;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.lengthOfLastWord("a b");
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int lengthOfLastWord(String s) {
        int res = 0;
        String trimmed = s.trim();
        for (int i = trimmed.length() - 1; i >= 0; i--, res++) {
            if (trimmed.charAt(i) == ' ')
                return res;
        }

        return res;
    }
}
