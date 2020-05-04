package com.github.barskiy.leetcode.problems.hashtable.findcommoncharacters_1002;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        List<String> res =
                solve.commonCharsWithArray(new String[]{"bella","label","roller"});
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<String> commonCharsWithArray(String[] A) {
        if (A == null || A.length == 0) return Collections.emptyList();
        final int lowerCaseNumberOfAInAscii = 97;

        int[] dict = new int[26];
        int[] occurs = new int[26];
        Arrays.fill(dict, Integer.MAX_VALUE);

        for (int i = 0; i < A.length; i++) {
            Map<Character, Integer> charsOccurrence = new HashMap<>(A[i].length());
            char[] chars = A[i].toCharArray();
            for (char c : chars)
                charsOccurrence.put(c, charsOccurrence.getOrDefault(c, 0) + 1);

            for (Map.Entry<Character, Integer> charToOccurrenceInWord : charsOccurrence.entrySet()) {
                int pos = charToOccurrenceInWord.getKey() - lowerCaseNumberOfAInAscii;
                if (i == occurs[pos]) {
                    dict[pos] = Math.min(dict[pos], charToOccurrenceInWord.getValue());
                    occurs[pos]++;
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (occurs[i] == A.length) {
                for (int j = 0; j < dict[i]; j++) {
                    String character = String.valueOf((char) (lowerCaseNumberOfAInAscii + i));
                    res.add(character);
                }
            }
        }
        return res;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<String> commonChars(String[] A) {
        if (A == null || A.length == 0) return Collections.emptyList();

        Map<Character, Integer> charsToCount = new HashMap<>();

        char[] chars = A[0].toCharArray();
        for (char c : chars) {
            charsToCount.put(c, charsToCount.getOrDefault(c, 0) + 1);
        }

        for (int i = 1; i < A.length; i++) {
            chars = A[i].toCharArray();
            Map<Character, Integer> visited = new HashMap<>();

            for (char c : chars) {
                if (charsToCount.containsKey(c)) {
                    visited.put(c, visited.getOrDefault(c, 0) + 1);
                }
            }

            charsToCount.keySet().retainAll(visited.keySet());
            for (Map.Entry<Character, Integer> charToCountInWords : charsToCount.entrySet()) {
                Character key = charToCountInWords.getKey();
                charsToCount.put(key,
                        Math.min(charsToCount.get(key), visited.get(key)));
            }
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<Character, Integer> charAndCount : charsToCount.entrySet()) {
            for (int i = 0; i < charAndCount.getValue(); i++) {
                res.add(String.valueOf(charAndCount.getKey()));
            }
        }
        return res;
    }
}
