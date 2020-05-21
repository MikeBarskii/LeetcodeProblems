package com.github.barskiy.leetcode.problems.array.removeduplicatesfromsortedarr2_80;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.removeDuplicates(new int[]{1,1,2,2,3,3});
        System.out.println(res);
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2])
                nums[i++] = num;
        }
        return i;
    }

    public int removeDuplicatesNotOptimized(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int insertIndex = 0, pointer = 0, repeated = 0, value = nums[0];
        while (true) {
            while (pointer < nums.length && repeated != 2 && nums[pointer] == value) {
                nums[insertIndex++] = nums[pointer++];
                repeated++;
            }

            while (pointer < nums.length && nums[pointer] == value) {
                pointer++;
            }

            if (pointer == nums.length)
                break;;

            repeated = 0;
            value = nums[pointer];
        }

        return insertIndex;
    }
}
