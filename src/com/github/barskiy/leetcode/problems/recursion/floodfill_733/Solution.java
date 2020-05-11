package com.github.barskiy.leetcode.problems.recursion.floodfill_733;

public class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor)
            floodFillHelper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void floodFillHelper(int[][] image, int sr, int sc, int prevColor, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[sr].length || image[sr][sc] != prevColor)
            return;

        image[sr][sc] = newColor;
        floodFillHelper(image, sr + 1, sc, prevColor, newColor);
        floodFillHelper(image, sr - 1, sc, prevColor, newColor);
        floodFillHelper(image, sr, sc + 1, prevColor, newColor);
        floodFillHelper(image, sr, sc - 1, prevColor, newColor);
    }
}
