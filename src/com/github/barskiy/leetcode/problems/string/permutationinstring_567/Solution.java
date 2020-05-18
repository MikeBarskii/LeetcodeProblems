package com.github.barskiy.leetcode.problems.string.permutationinstring_567;

public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] hash = new int[26];
        for (char c : s1.toCharArray()) {
            hash[c - 'a']++;
        }

        int left = 0, right = 0, counter = s1.length();
        while (right < s2.length()) {
            int rightCharIndex = s2.charAt(right) - 'a';
            if (hash[rightCharIndex] >= 1) {
                counter--;
            }
            hash[rightCharIndex]--;
            right++;

            if (counter == 0)
                return true;

            if (right - left == s1.length()) {
                int leftCharIndex = s2.charAt(left) - 'a';
                if (hash[leftCharIndex] >= 0)
                    counter++;
                hash[leftCharIndex]++;
                left++;
            }
        }
        return false;
    }
}
