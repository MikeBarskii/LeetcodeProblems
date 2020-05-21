package com.github.barskiy.leetcode.problems.hashtable.minnumberofstepstomakestwostringsanagram_1347;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.minSteps("bab", "aba");
        System.out.println(res);
    }

    public int minSteps(String s, String t) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) diff += arr[i];
        }

        return diff;
    }

    public int minStepsHashMap(String s, String t) {
        Map<Character, Integer> charToAmount = new HashMap<>();

        for (char c: t.toCharArray()) {
            charToAmount.put(c, charToAmount.getOrDefault(c, 0) + 1);
        }

        int diff = 0;
        for (char c: s.toCharArray()) {
            if (charToAmount.containsKey(c)) {
                int amount = charToAmount.get(c);
                if (amount == 0)
                    diff++;
                else
                    charToAmount.put(c, amount -1);
            } else
                diff++;
        }

        return diff;
    }
}
