package com.github.barskiy.leetcode.problems.array.sortarraybyparity_905;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] arr = {3, 1, 2, 4};
        solve.sortArrayByParity(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Time Complexity: O(n)
    //Space Complexity: O(1), in-place operation
    public int[] sortArrayByParity(int[] A) {
        int evenIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0)
                swap(A, evenIndex++, i);
        }
        return A;
    }

    private void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}
