package com.github.barskiy.leetcode.problems.backtracking.permutations2_47;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        List<List<Integer>> res = solve.permuteUnique(new int[]{1, 1, 2});
        res.forEach(System.out::println);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new LinkedList<>(), new boolean[nums.length], res);

        return res;
    }

    private void helper(int[] nums, LinkedList<Integer> permutation, boolean[] used, List<List<Integer>> res) {
        if (permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            permutation.add(nums[i]);

            helper(nums, permutation, used, res);

            used[i] = false;
            permutation.removeLast();

            while (i + 1 < nums.length && nums[i] == nums[i + 1])
                i++;
        }
    }

    public List<List<Integer>> permuteUniqueWithSet(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        permuteHelper(nums, set, new boolean[nums.length], new LinkedList<>());

        return new ArrayList<>(set);
    }

    private void permuteHelper(int[] nums, Set<List<Integer>> res, boolean[] used, LinkedList<Integer> current) {
        if (current.size() == nums.length) {
            res.add(new LinkedList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            current.add(nums[i]);
            used[i] = true;

            permuteHelper(nums, res, used, current);

            current.removeLast();
            used[i] = false;
        }
    }
}
