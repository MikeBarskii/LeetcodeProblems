package com.github.barskiy.leetcode.problems.stack.validparentheses_20;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        boolean res = solve.isValid("");
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) return true;
        if (s.length() % 2 != 0) return false;

        Map<Character, Character> closedTopOpen = new HashMap<>();
        closedTopOpen.put(')', '(');
        closedTopOpen.put('}', '{');
        closedTopOpen.put(']', '[');

        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char c : chars) {
            if (!closedTopOpen.containsKey(c))
                stack.push(c);
            else if (stack.isEmpty() || stack.pop() != closedTopOpen.get(c))
                return false;
        }

        return stack.isEmpty();
    }
}
