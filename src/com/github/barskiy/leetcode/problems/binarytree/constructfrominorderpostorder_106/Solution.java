package com.github.barskiy.leetcode.problems.binarytree.constructfrominorderpostorder_106;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();

        int[] inorder = new int[]{9, 5, 1, 7, 2, 12, 8, 4, 3, 11};
        int[] postorder = new int[]{9, 1, 2, 12, 7, 5, 3, 11, 4, 8};

        TreeNode root = solve.buildTree(inorder, postorder);
        System.out.println(root);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private final Map<Integer, Integer> inorderValueToIndex = new HashMap<>();
    private int last;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        if (inorder.length == 0) return null;

        for (int i = 0; i < inorder.length; i++)
            inorderValueToIndex.put(inorder[i], i);
        last = postorder.length - 1;

        return build(postorder, 0, last);
    }

    private TreeNode build(int[] postorder, int left, int right) {
        if (left > right) return null;
        TreeNode root = new TreeNode(postorder[last--]);
        int rootInorderIndex = inorderValueToIndex.get(root.val);
        root.right = build(postorder, rootInorderIndex + 1, right);
        root.left = build(postorder, left, rootInorderIndex - 1);

        return root;
    }

}
