package com.github.barskiy.leetcode.problems.queue.wallsandgates_286;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[][] rooms = new int[4][4];
        rooms[0][0] = Integer.MIN_VALUE;
        rooms[0][1] = -1;
        rooms[0][2] = 0;
        rooms[0][3] = Integer.MIN_VALUE;
        rooms[1][0] = Integer.MIN_VALUE;
        rooms[1][1] = Integer.MIN_VALUE;
        rooms[1][2] = Integer.MIN_VALUE;
        rooms[1][3] = -1;
        rooms[2][0] = Integer.MIN_VALUE;
        rooms[2][1] = -1;
        rooms[2][2] = Integer.MIN_VALUE;
        rooms[2][3] = -1;
        rooms[3][0] = 0;
        rooms[3][1] = -1;
        rooms[3][2] = Integer.MIN_VALUE;
        rooms[3][3] = Integer.MIN_VALUE;

        solve.wallsAndGates(rooms);
    }

    public void wallsAndGates(int[][] rooms) {

    }
}
