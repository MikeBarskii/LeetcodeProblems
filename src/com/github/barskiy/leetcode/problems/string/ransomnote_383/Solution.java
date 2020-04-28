package com.github.barskiy.leetcode.problems.string.ransomnote_383;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Time Complexity: O(m + n)
    // Space Complexity: O(n)
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charToCount = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            Integer count = charToCount.getOrDefault(c, 0);
            charToCount.put(c, count + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            Integer count = charToCount.getOrDefault(c, 0);
            if (count == 0) return false;
            else charToCount.put(c, count - 1);
        }

        return true;
    }
}
