package com.github.barskiy.leetcode.problems.recursion.pascalstriangle2_119;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        List<Integer> res = solve.getRow(3);
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public List<Integer> getRowIteratively(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int j = 1; j < i; j++) {
                current.add(prev.get(j - 1) + prev.get(j));
            }
            current.add(1);
            prev = current;
        }
        return prev;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(getRowHelper(rowIndex, i));
        }
        return res;
    }

    private int getRowHelper(int row, int column) {
        if (row < 2 || column == 0 || column == row) return 1;
        return getRowHelper(row - 1, column - 1)
                + getRowHelper(row - 1, column);
    }
}
