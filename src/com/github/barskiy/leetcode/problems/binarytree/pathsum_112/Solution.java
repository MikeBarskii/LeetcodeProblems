package com.github.barskiy.leetcode.problems.binarytree.pathsum_112;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getExample1();

        Solution solve = new Solution();
        boolean res = solve.hasPathSum(root, 1);
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }
}
