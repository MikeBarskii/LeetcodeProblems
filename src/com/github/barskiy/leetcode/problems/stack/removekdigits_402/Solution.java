package com.github.barskiy.leetcode.problems.stack.removekdigits_402;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        String res = solve.removeKdigits("12999", 2);
        System.out.println(res);
    }

    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }

            stack.push(c);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());

        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.reverse().toString();
    }
}
