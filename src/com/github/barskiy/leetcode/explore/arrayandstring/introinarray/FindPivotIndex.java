package com.github.barskiy.leetcode.explore.arrayandstring.introinarray;

public class FindPivotIndex {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 0, -1, 3}));
    }

    public static int pivotIndex(int[] nums) {
        if (nums.length < 2) return -1;

        int sum = 0;
        for (int num : nums) sum += num;

        int leftPart = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftPart == sum - leftPart - nums[i])
                return i;
            else
                leftPart += nums[i];
        }

        return -1;
    }
}
