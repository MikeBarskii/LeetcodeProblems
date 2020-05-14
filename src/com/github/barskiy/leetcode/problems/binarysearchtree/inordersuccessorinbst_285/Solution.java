package com.github.barskiy.leetcode.problems.binarysearchtree.inordersuccessorinbst_285;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

public class Solution {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (root.val > p.val) {
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return succ;
    }
}
