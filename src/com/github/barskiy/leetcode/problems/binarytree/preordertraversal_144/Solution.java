package com.github.barskiy.leetcode.problems.binarytree.preordertraversal_144;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getExample();

        Solution solve = new Solution();
        List<Integer> res = solve.preorderIterativeTraversal(root);
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderRecursiveTraversal(root, res);
        return res;
    }

    private void preorderRecursiveTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        nodes.add(root.val);
        preorderRecursiveTraversal(root.left, nodes);
        preorderRecursiveTraversal(root.right, nodes);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<Integer> preorderIterativeTraversal(TreeNode root) {
        if (root == null) return
                Collections.emptyList();

        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            res.addFirst(current.val);

            if (current.left != null)
                stack.push(current.left);

            if (current.right != null) {
                stack.push(current.right);
            }
        }

        return res;
    }

}
