package com.github.barskiy.leetcode.problems.array.findluckyintegerinarray_1394;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findLucky(int[] arr) {
        Map<Integer, Integer> numToOccurrence = new HashMap<>();
        for (int i : arr) {
            numToOccurrence.put(i, numToOccurrence.getOrDefault(i, 0) + 1);
        }

        int max = -1;
        for (Map.Entry<Integer, Integer> numToCount : numToOccurrence.entrySet()) {
            if (numToCount.getKey().equals(numToCount.getValue()))
                max = Math.max(max, numToCount.getKey());
        }

        return max;
    }
}
