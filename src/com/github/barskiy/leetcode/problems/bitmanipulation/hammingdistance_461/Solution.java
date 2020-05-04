package com.github.barskiy.leetcode.problems.bitmanipulation.hammingdistance_461;

public class Solution {

    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

}
