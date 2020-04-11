package com.github.barskiy.leetcode.explore.arrayandstring.twopointertechnique;

public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) break;
            if (numbers[start] + numbers[end] < target) start++;
            else end--;
        }
        return new int[] {start + 1, end + 1};
    }
}
