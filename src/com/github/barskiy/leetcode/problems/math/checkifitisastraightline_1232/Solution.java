package com.github.barskiy.leetcode.problems.math.checkifitisastraightline_1232;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[][] coordinates = new int[5][2];
        coordinates[0][0] = -3;
        coordinates[0][1] = -2;
        coordinates[1][0] = -1;
        coordinates[1][1] = -2;
        coordinates[2][0] = 2;
        coordinates[2][1] = -2;
        coordinates[3][0] = -2;
        coordinates[3][1] = -2;
        coordinates[4][0] = 0;
        coordinates[4][1] = -2;

        boolean res = solve.checkStraightLine(coordinates);
        System.out.println(res);
    }

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;

        // y = mx + b;
        // m = (y2 - y1) / (x2-x1)

        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];

        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];

        int m = (x2 - x1 == 0 || y2 - y1 == 0) ? 0 : (y2 - y1) / (x2 - x1);
        int b = (y1 - x1 * m);

        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];

            int currentB = (y - x * m);
            if (currentB != b)
                return false;
        }
        return true;
    }
}
