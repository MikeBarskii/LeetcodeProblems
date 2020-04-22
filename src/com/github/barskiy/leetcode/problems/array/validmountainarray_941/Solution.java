package com.github.barskiy.leetcode.problems.array.validmountainarray_941;

public class Solution {
    public static void main(String[] args) {
        Solution solve = new Solution();
        boolean res = solve.validMountainArray(new int[]{7, 3, 2, 1});
        System.out.println(res);
    }

    public boolean validMountainArray(int[] A) {
        if (A.length < 2)
            return false;

        int peak = 0;
        int lastIndex = A.length - 1;

        for (; peak < lastIndex; peak++) {
            if (A[peak] > A[peak + 1])
                break;
        }

        if (peak == 0 || peak == lastIndex)
            return false;

        for (int j = peak; j < lastIndex; j++) {
            if (A[j] <= A[j + 1])
                return false;
        }

        return true;
    }
}
