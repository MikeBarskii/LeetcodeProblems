package com.github.barskiy.leetcode.hashtable.hashmap;

import java.util.*;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> chars = new HashMap<>();
        Set<Character> replaceChars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char originalChar = s.charAt(i);
            char replaceChar = t.charAt(i);
            if (chars.containsKey(originalChar)) {
                if (chars.get(originalChar) != replaceChar)
                    return false;
            } else {
                if (replaceChars.contains(replaceChar))
                    return false;
                chars.put(originalChar, replaceChar);
                replaceChars.add(replaceChar);
            }
        }
        return true;
    }

    public boolean isIsomorphicOneMoreSolution(String s, String t) {
        if (s.length() != t.length())
             return false;

        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!Objects.equals(m1.put(s.charAt(i), i), m2.put(t.charAt(i), i)))
                return false;
        }
        return true;
    }
}
