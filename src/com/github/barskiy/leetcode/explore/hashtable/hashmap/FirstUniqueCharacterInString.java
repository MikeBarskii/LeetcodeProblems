package com.github.barskiy.leetcode.explore.hashtable.hashmap;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

    public static void main(String[] args) {

    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> charToIndex = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charToIndex.containsKey(c)) {
                charToIndex.put(c, -1);
            } else
                charToIndex.put(c, i);
        }

        for (int i = 0; i < s.length(); i++) {
            Integer index = charToIndex.get(s.charAt(i));
            if (index != -1)
                return index;
        }

        return -1;
    }
}
