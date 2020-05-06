package com.github.barskiy.leetcode.problems.stack.evaluatereversepolishnotation_150;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        System.out.println(res);
    }


    public int evalRPN(String[] tokens) {
        final Set<String> operators = new HashSet<>(Arrays.asList("/", "*", "+", "-"));
        Deque<Integer> numbers = new ArrayDeque<>();
        int res;

        for (String token : tokens) {
            if (!operators.contains(token)) {
                numbers.push(Integer.valueOf(token));
                continue;
            }

            Integer rightOperand = numbers.pop();
            Integer leftOperand = numbers.pop();

            switch (token) {
                case "/":
                    res = leftOperand / rightOperand;
                    break;
                case "*":
                    res = leftOperand * rightOperand;
                    break;
                case "+":
                    res = leftOperand + rightOperand;
                    break;
                default:
                    res = leftOperand - rightOperand;
                    break;
            }
            numbers.push(res);
        }
        return numbers.pop();
    }
}
