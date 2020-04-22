package com.github.barskiy.leetcode.problems.array.squaresofsortedarray_977;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] res = solve.sortedSquaresOptimized(new int[]{-4, -3, -1, 0, 3});
        System.out.println(Arrays.toString(res));
    }

    //Time Complexity: O(n)
    //Space Complexity: O(1), res is not countable
    public int[] sortedSquaresOptimizedAndLessCode(int[] A) {
        int length = A.length;
        int[] res = new int[length];
        int i = 0, j = length - 1;
        for (int p = length - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                res[p] = A[i] * A[i];
                i++;
            } else {
                res[p] = A[j] * A[j];
                j--;
            }
        }
        return res;
    }

    //Time Complexity: O(n)
    //Space Complexity: O(1), res is not countable
    public int[] sortedSquaresOptimized(int[] A) {
        int[] res = new int[A.length];

        if (A[0] <= 0 && A[A.length - 1] >= 0) {
            int i = 0;
            while (i < A.length && A[i] < 0) i++;

            int left = i - 1, right = i;
            for (int j = 0; j < A.length; j++) {
                if (right == A.length || (left >= 0 && Math.abs(A[left]) <= A[right]))
                    res[j] = getSquaredValue(A[left--]);
                else
                    res[j] = getSquaredValue(A[right++]);
            }
        } else {
            for (int i = 0; i < A.length; i++)
                res[i] = A[i] * A[i];
        }
        return res;
    }

    private int getSquaredValue(int value) {
        return value * value;
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
