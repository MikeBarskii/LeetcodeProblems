package com.github.barskiy.leetcode.problems.array.containerwithmostwater_11;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int currentMax = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currentMax);

            if (height[left] <= height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
