package com.github.barskiy.leetcode.problems.binarytree.maxdepthofbinarytee_104;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getExample();

        Solution solve = new Solution();
        int res = solve.maxDepth(root);
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
