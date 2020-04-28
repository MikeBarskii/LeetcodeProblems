package com.github.barskiy.leetcode.problems.binarytree.searchinbst_700;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

public class Solution {

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) return root;
        else if (root.val > val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);

    }
}
