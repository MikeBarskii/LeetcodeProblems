package com.github.barskiy.leetcode.problems.bitmanipulation.findthedifference_389;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        String s = "abcd";
        String s1 = "dacbe";
        char res = solve.findTheDifference(s, s1);
        System.out.println(res);
    }

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public char findTheDifference(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++)
            res ^= s.charAt(i) ^ t.charAt(i);

        res ^= t.charAt(t.length() - 1);
        return (char) res;
    }
}
