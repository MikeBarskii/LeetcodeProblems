package com.github.barskiy.leetcode.problems.binarytree.postordertraversal_145;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getExample();

        Solution solve = new Solution();
        List<Integer> res = solve.postorderTraversal(root);
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderRecursiveTraversal(root, res);
        return res;
    }

    private void postorderRecursiveTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        postorderRecursiveTraversal(root.left, nodes);
        postorderRecursiveTraversal(root.right, nodes);
        nodes.add(root.val);
    }

    public List<Integer> postorderIterativeTraversal(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            stack.push(cur);

            if (cur.right != null)
                stack.push(cur.right);

            if (cur.left != null)
                stack.push(cur.left);
        }

        return res;
    }
}
