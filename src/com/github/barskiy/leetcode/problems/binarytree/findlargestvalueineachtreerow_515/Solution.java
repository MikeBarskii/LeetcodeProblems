package com.github.barskiy.leetcode.problems.binarytree.findlargestvalueineachtreerow_515;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        root.left = node3;
        root.right = node2;
        node3.left = new TreeNode(5);
        node3.right = new TreeNode(3);
        node2.right = new TreeNode(9);

        Solution solve = new Solution();
        List<Integer> res = solve.largestValues(root);
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;
        while (!queue.isEmpty()) {
            Integer max = null;
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if (max == null || node.val > max)
                    max = node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(max);
            level = queue.size();
        }

        return res;
    }
}
