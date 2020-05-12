package com.github.barskiy.leetcode.problems.array.peakindexinamountainarray_852;

public class Solution {

    public int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1])
                return i - 1;
        }
        return A[A.length - 1];
    }
}
