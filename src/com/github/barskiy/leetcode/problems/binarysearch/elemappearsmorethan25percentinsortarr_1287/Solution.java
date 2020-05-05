package com.github.barskiy.leetcode.problems.binarysearch.elemappearsmorethan25percentinsortarr_1287;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.findSpecialInteger(new int[]{1, 1, 2, 2, 2, 2, 8, 9, 10, 11});
        System.out.println(res);
    }

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int findSpecialIntegerLinearSolution(int[] arr) {
        int window = arr.length / 4;
        for (int i = 0; i < arr.length - window; i++) {
            if (arr[i] == arr[i + window])
                return arr[i];
        }
        return -1;
    }

    //Time Complexity: O(log(n))
    //Space Complexity: O(1)
    public int findSpecialInteger(int[] arr) {
        if (arr.length == 1) return arr[0];

        int length = arr.length;
        List<Integer> firstThreeQuarters =
                new ArrayList<>(Arrays.asList(arr[length / 4], arr[length / 2], arr[3 * length / 4]));

        for (Integer elem : firstThreeQuarters) {
            int pos = firstOccurrence(arr, elem);
            if (arr[pos + length / 4] == elem)
                return elem;
        }
        return -1;
    }

    private int firstOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid])
                start = mid + 1;
            else
                end = mid;
        }
        return end;
    }
}
