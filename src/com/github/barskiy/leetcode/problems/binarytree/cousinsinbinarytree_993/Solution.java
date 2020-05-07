package com.github.barskiy.leetcode.problems.binarytree.cousinsinbinarytree_993;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.right = node2;
        node2.left = node3;
        node3.right = new TreeNode(5);
        node3.left = node4;

        Solution solve = new Solution();
        boolean res = solve.isCousins(node1, 5, 1);
        System.out.println(res);
    }

    int parentLevel = Integer.MAX_VALUE;

    public boolean isCousins(TreeNode root, int x, int y) {
        int node1Parent = getParentValue(root, 0, x);
        int node1ParentLevel = parentLevel;

        int node2Parent = getParentValue(root, 0, y);

        return node1ParentLevel == parentLevel
                && node1Parent != -1 && node2Parent != -1
                && node1Parent != node2Parent;
    }

    private int getParentValue(TreeNode root, int level, int value) {
        if (root == null || level > parentLevel) return -1;

        if (root.left != null && root.left.val == value) {
            parentLevel = level;
            return root.val;
        } else if (root.right != null && root.right.val == value) {
            parentLevel = level;
            return root.val;
        }

        return Math.max(getParentValue(root.left, level + 1, value),
                getParentValue(root.right, level + 1, value));
    }
}
