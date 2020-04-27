package com.github.barskiy.leetcode.problems.binarytree.validatebinarysearchtree_98;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

public class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private boolean isValidBSTHelper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;

        if (lower != null && root.val <= lower) return false;
        if (upper != null && root.val >= upper) return false;

        if (!isValidBSTHelper(root.left, lower, root.val)) return false;
        if (!isValidBSTHelper(root.right, root.val, upper)) return false;

        return true;
    }
}
