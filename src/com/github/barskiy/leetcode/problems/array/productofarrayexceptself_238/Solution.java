package com.github.barskiy.leetcode.problems.array.productofarrayexceptself_238;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] res = solve.productExceptSelfOptimized(new int[]{2, 3, 4, 5, 6});
        System.out.println(Arrays.toString(res));
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int[] productExceptSelfOptimized(int[] nums) {
        int size = nums.length;

        int[] res = new int[size];

        res[0] = 1;
        for (int i = 1; i < size; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int product = 1;
        for (int i = size - 1; i >= 0; i--) {
            res[i] = res[i] * product;
            product *= nums[i];
        }

        return res;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;

        int[] L = new int[size];
        int[] R = new int[size];

        L[0] = 1;
        for (int i = 1; i < size; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        R[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = L[i] * R[i];
        }

        return res;
    }
}
