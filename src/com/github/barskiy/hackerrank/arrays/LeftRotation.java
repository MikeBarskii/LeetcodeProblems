package com.github.barskiy.hackerrank.arrays;

public class LeftRotation {

    static int[] rotLeft(int[] a, int d) {
        d %= a.length;
        reverse(a, 0, a.length - 1);
        reverse(a, 0, a.length - d - 1);
        reverse(a, a.length - d, a.length - 1);
        return a;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
