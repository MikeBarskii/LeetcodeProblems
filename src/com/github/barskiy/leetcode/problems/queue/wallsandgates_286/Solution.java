package com.github.barskiy.leetcode.problems.queue.wallsandgates_286;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[][] rooms = new int[4][4];
        rooms[0][0] = Integer.MAX_VALUE;
        rooms[0][1] = -1;
        rooms[0][2] = 0;
        rooms[0][3] = Integer.MAX_VALUE;
        rooms[1][0] = Integer.MAX_VALUE;
        rooms[1][1] = Integer.MAX_VALUE;
        rooms[1][2] = Integer.MAX_VALUE;
        rooms[1][3] = -1;
        rooms[2][0] = Integer.MAX_VALUE;
        rooms[2][1] = -1;
        rooms[2][2] = Integer.MAX_VALUE;
        rooms[2][3] = -1;
        rooms[3][0] = 0;
        rooms[3][1] = -1;
        rooms[3][2] = Integer.MAX_VALUE;
        rooms[3][3] = Integer.MAX_VALUE;

        solve.wallsAndGates(rooms);
    }

    // Time Complexity: O(mn)
    // Space Complexity: O(mn)
    public void wallsAndGates(int[][] rooms) {
        final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] room = queue.poll();
            int distance = rooms[room[0]][room[1]];

            for (int[] direction : directions) {
                int row = direction[0] + room[0];
                int column = direction[1] + room[1];

                if (row >= 0 && column >= 0
                        && row < rooms.length
                        && column < rooms[0].length
                        && rooms[row][column] == Integer.MAX_VALUE) {
                    rooms[row][column] = distance + 1;
                    queue.offer(new int[]{row, column});
                }
            }
        }
    }
}
