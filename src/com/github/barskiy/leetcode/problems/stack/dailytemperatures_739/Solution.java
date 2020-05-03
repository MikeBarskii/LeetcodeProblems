package com.github.barskiy.leetcode.problems.stack.dailytemperatures_739;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] res = solve.dailyTemperatures(new int[]{55, 38, 53, 81, 61, 93, 97, 32, 43, 78});
        System.out.println(Arrays.toString(res));
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Deque<Integer> highTemperatures = new LinkedList<>();

        for (int i = T.length - 1; i >= 0; i--) {
            while (!highTemperatures.isEmpty() && T[highTemperatures.peek()] <= T[i])
                highTemperatures.pop();

            res[i] = highTemperatures.isEmpty() ? 0 : highTemperatures.peek() - i;

            highTemperatures.push(i);
        }

        return res;
    }

}
