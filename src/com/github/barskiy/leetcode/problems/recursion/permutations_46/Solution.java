package com.github.barskiy.leetcode.problems.recursion.permutations_46;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        List<List<Integer>> res = solve.permute(new int[]{1, 2, 3});
        System.out.println(res);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteHelper(nums, new HashSet<>(), new LinkedList<>(), res);
        return res;
    }

    // Time Complexity: O(n!)
    // Space Complexity: O(n!)
    private void permuteHelper(int[] nums, Set<Integer> cur, LinkedList<Integer> curOrdered, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(curOrdered));
            return;
        }

        for (Integer value : nums) {
            if (cur.contains(value))
                continue;

            cur.add(value);
            curOrdered.add(value);

            permuteHelper(nums, cur, curOrdered, res);

            cur.remove(value);
            curOrdered.removeLast();
        }
    }
    
}
