package com.github.barskiy.leetcode.problems.binarytree.validatebinarysearchtree_98;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

public class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private boolean isValidBSTHelper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;

        int val = root.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!isValidBSTHelper(root.left, lower, val)) return false;
        if (!isValidBSTHelper(root.right, val, upper)) return false;

        return true;
    }
}
