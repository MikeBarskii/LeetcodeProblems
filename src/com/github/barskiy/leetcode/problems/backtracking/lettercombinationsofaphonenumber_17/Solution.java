package com.github.barskiy.leetcode.problems.backtracking.lettercombinationsofaphonenumber_17;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        List<String> res = solve.letterCombinations("23");
        System.out.println(res);
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return Collections.emptyList();
        final String[] letters = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        LinkedList<String> combinations = new LinkedList<>();
        combinations.add("");
        for (int i = 0; i < digits.length(); i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            while (combinations.peek().length() == i) {
                String prev = combinations.remove();
                for (Character c : letters[digit].toCharArray())
                    combinations.add(prev + c);
            }
        }

        return combinations;
    }
}
