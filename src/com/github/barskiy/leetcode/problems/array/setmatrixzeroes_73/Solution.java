package com.github.barskiy.leetcode.problems.array.setmatrixzeroes_73;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public void setZeroesOptimized(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowToZero = false, firstColumnToZero = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0) firstRowToZero = true;
                    if (j == 0) firstColumnToZero = true;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (firstRowToZero) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColumnToZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows.contains(i) || columns.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }
}
