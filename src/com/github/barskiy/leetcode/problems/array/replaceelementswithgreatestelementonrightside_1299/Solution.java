package com.github.barskiy.leetcode.problems.array.replaceelementswithgreatestelementonrightside_1299;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] arr = {17, 18, 5, 4, 6, 1};
        solve.replaceElements(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Time Complexity: O(n)
    //Space Complexity: O(1), in-place operation
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            if (temp > max)
                max = temp;
        }
        return arr;
    }

}
