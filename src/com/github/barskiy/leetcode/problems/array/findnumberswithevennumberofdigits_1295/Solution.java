package com.github.barskiy.leetcode.problems.array.findnumberswithevennumberofdigits_1295;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.findNumbers(new int[]{});
        System.out.println(res);
    }

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int findNumbers(int[] nums) {
        int evenNumberOfDigits = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0)
                evenNumberOfDigits++;
        }

        return evenNumberOfDigits;
    }
}
