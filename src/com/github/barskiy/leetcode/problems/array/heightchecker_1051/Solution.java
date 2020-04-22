package com.github.barskiy.leetcode.problems.array.heightchecker_1051;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.heightChecker(new int[]{5,1,2,3,4});
        System.out.println(res);
    }

    //Time Complexity: O(n)
    //Space Complexity: O(nlogn)
    public int heightChecker(int[] heights) {
        int[] sorted = new int[heights.length];
        System.arraycopy(heights, 0, sorted, 0, heights.length);

        Arrays.sort(sorted);
        int diff = 0;
        for (int i = 0; i < heights.length; i++) {
            if (sorted[i] != heights[i])
                diff++;
        }

        return diff;
    }
}
