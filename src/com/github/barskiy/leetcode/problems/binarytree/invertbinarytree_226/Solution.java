package com.github.barskiy.leetcode.problems.binarytree.invertbinarytree_226;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
