package com.github.barskiy.leetcode.problems.array.squaresofsortedarray_977;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] res = solve.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(res));
    }

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int[] sortedSquaresOptimized(int[] A) {
            //TODO
        return new int[]{};
    }

    //Time Complexity: O(nlogn)
    //Space Complexity: O(1)
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];

        for (int i = 0; i < A.length; i++)
            res[i] = A[i] * A[i];

        Arrays.sort(res);
        return res;
    }
}
