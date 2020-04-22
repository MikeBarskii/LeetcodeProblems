package com.github.barskiy.leetcode.problems.array.duplicatezeroes_1089;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int[] arr = new int[]{0, 0, 0, 0, 0, 0, 0};
        int[] arr = new int[]{1, 2, 3, 0};
        solve.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void duplicateZeros(int[] arr) {
        int length = arr.length - 1;
        int possibleDups = 0;

        for (int i = 0; i <= length - possibleDups; i++) {
            if (arr[i] == 0) {
                if (i == length - possibleDups) {
                    arr[length--] = 0;
                    break;
                }
                possibleDups++;
            }
        }

        if (possibleDups == 0)
            return;

        int last = length - possibleDups;

        for (int i = last; i >= 0; i--, length--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
            }
            arr[i + possibleDups] = arr[i];
        }
    }
}
