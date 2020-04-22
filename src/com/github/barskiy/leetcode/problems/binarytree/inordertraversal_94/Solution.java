package com.github.barskiy.leetcode.problems.binarytree.inordertraversal_94;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getExample();

        Solution solve = new Solution();
        List<Integer> res = solve.inorderIterativeTraversal(root);
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();
        inorderRecursiveTraversal(root, res);
        return res;
    }

    private void inorderRecursiveTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        inorderRecursiveTraversal(root.left, nodes);
        nodes.add(root.val);
        inorderRecursiveTraversal(root.right, nodes);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<Integer> inorderIterativeTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
