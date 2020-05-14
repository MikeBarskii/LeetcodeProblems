package com.github.barskiy.leetcode.problems.binarysearchtree.insertintoabst_701;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        root.left = node2;
        root.right = new TreeNode(7);
        node2.left = new TreeNode(1);
        node2.right = new TreeNode(1);

        Solution solve = new Solution();
        TreeNode node = solve.insertIntoBST(root, 5);
        System.out.println(node);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) root.right = insertIntoBST(root.right, val);
        else root.left = insertIntoBST(root.left, val);

        return root;
    }
}
