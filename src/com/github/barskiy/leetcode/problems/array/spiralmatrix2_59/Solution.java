package com.github.barskiy.leetcode.problems.array.spiralmatrix2_59;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        solve.generateMatrix(5);
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int value = 1;
        int i = 0, j = 0;
        int minI = 0, maxI = n - 1, minJ = 0, maxJ = n - 1;
        while (minI <= maxI && minJ <= maxJ) {
            while (j <= maxJ) {
                res[i][j++] = value++;
            }
            minI++;
            j--;
            i++;

            while(i <= maxI) {
                res[i++][j] = value++;
            }
            maxI--;
            maxJ--;
            i--;
            j--;

            while(j >= minJ) {
                res[i][j--] = value++;
            }
            minJ++;
            i--;
            j++;

            while (i >= minI) {
                res[i--][j] = value++;
            }
            i++;
            j++;
        }

        return res;
    }
}
