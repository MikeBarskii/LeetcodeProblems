package com.github.barskiy.leetcode.problems.binarysearch.firstbadversion_278;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.firstBadVersion(5);
        System.out.println(res);
    }


    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) end = mid - 1;
            else start = mid + 1;
        }

        return start;
    }

    // method from the problem
    boolean isBadVersion(int version) {
        return version >= 3;
    }
}
