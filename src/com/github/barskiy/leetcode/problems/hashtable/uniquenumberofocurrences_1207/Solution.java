package com.github.barskiy.leetcode.problems.hashtable.uniquenumberofocurrences_1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        boolean res = solve.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3, 2});
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> valueToCount = new HashMap<>();
        for (int num : arr)
            valueToCount.put(num, valueToCount.getOrDefault(num, 0) + 1);

        Set<Integer> occurrences = new HashSet<>();
        for (Integer value : valueToCount.values()) {
            if (!occurrences.add(value))
                return false;
        }
        return true;
    }
}
