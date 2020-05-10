package com.github.barskiy.leetcode.problems.binarysearchtree.kthsmallestinbst_230;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        root.left = node1;
        root.right = new TreeNode(4);
        node1.right = new TreeNode(2);

        Solution solve = new Solution();
        int res = solve.kthSmallest(root, 1);
        System.out.println(res);
    }

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (--k == 0)
                return cur.val;
            cur = cur.right;
        }

        return -1;
    }
}
