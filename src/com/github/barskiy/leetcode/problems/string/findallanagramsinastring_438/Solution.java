package com.github.barskiy.leetcode.problems.string.findallanagramsinastring_438;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        List<Integer> res = solve.findAnagramsOptimal("cbaebabacd", "abc");
        System.out.println(res);
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) return Collections.emptyList();

        int[] charsInAnagram = new int[26];
        for (char c : p.toCharArray()) {
            charsInAnagram[c - 'a']++;
        }

        List<Integer> res = new ArrayList<>();
        int anagramStringLength = p.length();
        int lastPossibleIndex = s.length() - anagramStringLength;
        int[] currentCopy = new int[26];
        for (int i = 0; i <= lastPossibleIndex; i++) {
            int j = i;
            int countedLetters = 0;
            while (countedLetters < anagramStringLength
                    && charsInAnagram[s.charAt(j) - 'a'] != 0) {
                countedLetters++;
                currentCopy[s.charAt(j++) - 'a']++;
            }

            if (countedLetters == anagramStringLength
                    && Arrays.equals(charsInAnagram, currentCopy))
                res.add(i);

            currentCopy = new int[26];
        }

        return res;
    }

    public List<Integer> findAnagramsOptimal(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length())
            return res;

        int[] hash = new int[26];
        for (char c : p.toCharArray()) {
            hash[c - 'a']++;
        }

        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            int indexOfRightChar = s.charAt(right) - 'a';
            if (hash[indexOfRightChar] >= 1) {
                count--;
            }
            hash[indexOfRightChar]--;
            right++;

            if (count == 0)
                res.add(left);

            if (right - left == p.length()) {
                int indexOfLeftChar = s.charAt(left) - 'a';
                if (hash[indexOfLeftChar] >= 0) {
                    count++;
                }

                hash[indexOfLeftChar]++;
                left++;
            }
        }

        return res;
    }
}
