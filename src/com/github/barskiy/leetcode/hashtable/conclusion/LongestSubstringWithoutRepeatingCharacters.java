package com.github.barskiy.leetcode.hashtable.conclusion;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToIndex = new HashMap<>();
        int res = 0, start = 0, i = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charToIndex.containsKey(c) && charToIndex.get(c) >= start) {
                res = Math.max(i - start, res);
                start = charToIndex.get(c) + 1;
            }
            charToIndex.put(c, i);
        }
        return Math.max(i - start, res);
    }

}
