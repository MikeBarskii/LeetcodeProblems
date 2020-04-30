package com.github.barskiy.leetcode.problems.greedy.queuereconstructionbyheight_406;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (people1, people2) -> {
            int height1 = people1[0];
            int height2 = people2[0];
            return (height1 != height2) ? height2 - height1 : height1 - height2;
        });

        List<int[]> res = new LinkedList<>();
        for (int[] person : people) {
            res.add(person[1], person);
        }

        return res.toArray(new int[people.length][]);
    }
}
