package com.github.barskiy.leetcode.problems.recursion.numberofislands_200;

public class Solution {

    // Time Complexity: O(mn)
    // Space Complexity: O(mn)
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    sinkIsland(grid, i, j);
                }
            }
        }

        return count;
    }

    private void sinkIsland(char[][] grid, int row, int column) {
        if (row < 0 || column < 0 ||
                row >= grid.length || column >= grid[row].length ||
                grid[row][column] != '1')
            return;

        grid[row][column] = '0';
        sinkIsland(grid, row + 1, column);
        sinkIsland(grid, row - 1, column);
        sinkIsland(grid, row, column + 1);
        sinkIsland(grid, row, column - 1);
    }
}
