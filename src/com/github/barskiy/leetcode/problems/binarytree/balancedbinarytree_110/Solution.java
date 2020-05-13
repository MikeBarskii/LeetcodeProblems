package com.github.barskiy.leetcode.problems.binarytree.balancedbinarytree_110;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node2_1 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node3_1 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node4_1 = new TreeNode(4);
        node1.left = node2;
        node1.right = node2_1;
        node2.left = node3;
        node2.right = node3_1;
        node3.left = node4;
        node3.right = node4_1;

        Solution solve = new Solution();
        boolean res = solve.isBalanced(node1);
        System.out.println(res);
    }

    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return isBalanced;
    }

    private int getHeight(TreeNode root) {
        if (!isBalanced) return 0;
        if (root == null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (Math.abs(left - right) > 1)
            isBalanced = false;

        return 1 + Math.max(left, right);
    }
}
