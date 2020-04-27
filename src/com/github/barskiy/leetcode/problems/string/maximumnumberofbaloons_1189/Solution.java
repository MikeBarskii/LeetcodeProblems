package com.github.barskiy.leetcode.problems.string.maximumnumberofbaloons_1189;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for(char c: "balloon".toCharArray())
            charToCount.put(c, 0);

        for(char c: text.toCharArray()) {
            if (charToCount.containsKey(c))
                charToCount.put(c, charToCount.get(c) + 1);
        }

        for (Integer value : charToCount.values()) if (value == 0) return 0;

        return Math.min(charToCount.get('l') / 2, charToCount.get('o') / 2);
    }
}
