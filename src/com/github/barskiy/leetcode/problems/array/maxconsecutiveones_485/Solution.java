package com.github.barskiy.leetcode.problems.array.maxconsecutiveones_485;

public class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, consecutive = 0;
        for (int num : nums) {
            if (num == 1)
                consecutive++;
            else {
                max = Math.max(max, consecutive);
                consecutive = 0;
            }
        }
        return Math.max(max, consecutive);
    }
}
