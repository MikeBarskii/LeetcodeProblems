package com.github.barskiy.leetcode.problems.hashtable.jewelsandstones_771;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Time Complexity: O(n + m)
    // Space Complexity: O(n)
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        Set<Character> jewels = new HashSet<>();

        for (int i = 0; i < J.length(); i++)
            jewels.add(J.charAt(i));

        for (int i = 0; i < S.length(); i++) {
            if (jewels.contains(S.charAt(i)))
                res++;
        }
        return res;
    }
}
