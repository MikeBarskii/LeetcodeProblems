package com.github.barskiy.leetcode.explore.arrayandstring.introinarray;

public class LargestNumberAtLeastTwiceOfOthers {
    public static void main(String[] args) {
        dominantIndex(new int[] {1, 0});
    }
    public static int dominantIndex(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return 0;

        int maxNumber = Integer.MIN_VALUE;
        int dominantIndex = -1;
        int secondIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value > maxNumber) {
                maxNumber = value;
                dominantIndex = i;
                secondIndex = dominantIndex;
            } else if (secondIndex == -1 || value > nums[secondIndex])
                secondIndex = i;
        }

        if (nums[dominantIndex] > nums[secondIndex] * 2)
            return dominantIndex;
        else return -1;
    }
}
