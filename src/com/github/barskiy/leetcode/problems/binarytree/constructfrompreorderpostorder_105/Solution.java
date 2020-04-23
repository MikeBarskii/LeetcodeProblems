package com.github.barskiy.leetcode.problems.binarytree.constructfrompreorderpostorder_105;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();

        int[] preorder = new int[]{8, 5, 9, 7, 1, 12, 2, 4, 11, 3};
        int[] inorder = new int[]{9, 5, 1, 7, 2, 12, 8, 4, 3, 11};

        TreeNode root = solve.buildTree(preorder, inorder);
        System.out.println(root);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private final Map<Integer, Integer> inorderValueToIndex = new HashMap<>();
    private int first = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        if (preorder.length == 0) return null;

        for (int i = 0; i < inorder.length; i++) inorderValueToIndex.put(inorder[i], i);

        return build(preorder, first, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) return null;
        TreeNode node = new TreeNode(preorder[first++]);
        int inorderIndex = inorderValueToIndex.get(node.val);
        node.left = build(preorder, left, inorderIndex - 1);
        node.right = build(preorder, inorderIndex + 1, right);

        return node;
    }
}
