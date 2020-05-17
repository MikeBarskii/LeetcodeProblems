package com.github.barskiy.leetcode.problems.string.findallanagramsinastring_438;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        List<Integer> res = solve.findAnagrams("abab", "ab");
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

}
