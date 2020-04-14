package com.github.barskiy.leetcode.problems.array.contiguousarray_507;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1});
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> countToIndex = new HashMap<>();
        countToIndex.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                count++;
            else
                count--;

            if (countToIndex.containsKey(count)) {
                maxlen = Math.max(maxlen, i - countToIndex.get(count));
            } else {
                countToIndex.put(count, i);
            }
        }
        return maxlen;
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int findMaxLengthBruteForce(int[] nums) {
        int max = 0;
        for (int start = 0; start < nums.length; start++) {
            int zeroes = 0, ones = 0;
            for (int end = start; end < nums.length; end++) {
                if (nums[end] == 0)
                    zeroes++;
                else
                    ones++;

                if (zeroes == ones)
                    max = Math.max(max, end - start + 1);
            }
        }
        return max;
    }

}
