package com.github.barskiy.leetcode.problems.bitmanipulation.majorityelement_169;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.majorityElement(new int[]{4, 4, 1, 1, 1, 4, 4, 4, 3});
        System.out.println(res);
    }

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    //Boyer-Moore Voting Algorithm
    public int majorityElementOptimized(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0)
                candidate = num;

            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> valueToCount = new HashMap<>();
        int max = 0;
        int maxElement = -1;
        for (int num : nums) {
            int count = valueToCount.getOrDefault(num, 0) + 1;
            if (count > max) {
                max = count;
                maxElement = num;
            }
            valueToCount.put(num, count);
        }

        return maxElement;
    }
}
