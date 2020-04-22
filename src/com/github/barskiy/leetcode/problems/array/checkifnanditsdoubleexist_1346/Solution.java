package com.github.barskiy.leetcode.problems.array.checkifnanditsdoubleexist_1346;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        boolean res = solve.checkIfExist(new int[]{3, 1, 7, 9});
        System.out.println(res);
    }

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public boolean checkIfExist(int[] arr) {
        Set<Integer> doubledValues = new HashSet<>();
        for (int i : arr) {
            if (doubledValues.contains(i * 2) ||
                    (i % 2 == 0 && doubledValues.contains(i / 2)))
                return true;
            doubledValues.add(i);
        }
        return false;
    }
}
