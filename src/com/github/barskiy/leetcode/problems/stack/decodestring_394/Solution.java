package com.github.barskiy.leetcode.problems.stack.decodestring_394;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        String res = solve.decodeString("100[leetcode]");
        System.out.println(res);
    }

    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();

        int i = s.length() - 1;
        while (i >= 0) {
            char character = s.charAt(i);
            if (!Character.isDigit(character)) {
                stack.push(String.valueOf(character));
                i--;
                continue;
            }

            stack.pop(); // remove open bracket
            StringBuilder letters = new StringBuilder();
            while (!stack.peek().equals("]")) {
                letters.append(stack.pop());
            }
            stack.pop(); // remove close bracket

            StringBuilder digit = new StringBuilder();
            digit.append(character);
            while (i - 1 >= 0 && Character.isDigit(s.charAt(i - 1))) {
                digit.append(s.charAt(i - 1));
                i--;
            }
            int repeatNumber = Integer.parseInt(digit.reverse().toString());

            stack.push(letters.toString().repeat(repeatNumber));
            i--;
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.toString();
    }
}
