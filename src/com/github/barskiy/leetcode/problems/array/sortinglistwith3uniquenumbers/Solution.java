package com.github.barskiy.leetcode.problems.array.sortinglistwith3uniquenumbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] arr = new int[]{3, 3, 2, 1, 3, 2, 1};
        solve.sortOptimized(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void sortOptimized(int[] nums) {
        int oneIndex = 0;
        int threeIndex = nums.length - 1;
        int i = 0;
        while (i < threeIndex) {
            if (nums[i] == 1) {
                swap(nums, i++, oneIndex++);
            } else if (nums[i] == 2)
                i++;
            else if (nums[i] == 3)
                swap(nums, i, threeIndex--);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // Array contains only 1, 2, 3
    public void sort(int[] nums) {
        Map<Integer, Integer> valueToCount = new HashMap<>();
        for (int num : nums) {
            Integer count = valueToCount.getOrDefault(num, 0);
            valueToCount.put(num, count + 1);
        }

        int i = 0;
        while (i < nums.length) {
            for (int j = 1; j <= 3; j++) {
                int count = valueToCount.get(j);
                for (int n = 0; n < count; n++) {
                    nums[i++] = j;
                }
            }
        }
    }
}
