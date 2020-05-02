package com.github.barskiy.leetcode.problems.binarytree.univaluedbinarytree_965;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

public class Solution {

    // Time Complexity: O(n)
    // Space Complexity: O(h)
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return isUnivalTreeHelper(root, root.val);
    }

    private boolean isUnivalTreeHelper(TreeNode root, int value) {
        if (root == null) return true;
        if (root.val != value) return false;
        return isUnivalTreeHelper(root.left, value) && isUnivalTreeHelper(root.right, value);
    }

}
