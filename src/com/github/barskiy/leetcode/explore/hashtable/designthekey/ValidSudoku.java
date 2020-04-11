package com.github.barskiy.leetcode.explore.hashtable.designthekey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, List<int[]>> valueToLocation = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                int value = board[i][j] - '0';
                if (valueToLocation.containsKey(value)) {
                    List<int[]> indices = valueToLocation.get(value);
                    for (int[] index : indices) {
                        int row = index[0];
                        int column = index[1];
                        if (row == i || column == j || (row / 3 == i / 3 && column / 3 == j / 3))
                            return false;
                    }
                    indices.add(new int[]{i, j});
                } else {
                    List<int[]> index = new ArrayList<>(9);
                    index.add(new int[]{i, j});
                    valueToLocation.put(value, index);
                }
            }
        }
        return true;
    }
}
