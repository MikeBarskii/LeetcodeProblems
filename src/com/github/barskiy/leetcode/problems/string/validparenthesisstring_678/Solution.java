package com.github.barskiy.leetcode.problems.string.validparenthesisstring_678;

import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        boolean res = solve.checkValidStringOptimized("*(");
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public boolean checkValidStringOptimized(String s) {
        int bal = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '*') bal++;
            else if (bal-- == 0)
                return false;
        }

        if (bal == 0) return true;

        bal = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')' || c == '*') bal++;
            else if (bal-- == 0)
                return false;
        }

        return true;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean checkValidString(String s) {
        if (s.length() == 0)
            return true;

        LinkedList<Integer> opened = new LinkedList<>();
        LinkedList<Integer> stars = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                opened.add(i);
            else if (c == '*')
                stars.add(i);
            else {
                if (opened.isEmpty() && stars.isEmpty())
                    return false;
                if (opened.isEmpty())
                    stars.removeLast();
                else
                    opened.removeLast();
            }
        }

        if (opened.size() > stars.size())
            return false;

        while (!opened.isEmpty() && !stars.isEmpty()) {
            if (opened.removeLast() > stars.removeLast())
                return false;
        }

        return opened.isEmpty();
    }
}
