package com.github.barskiy.leetcode.problems.binarytree.levelordertraversal_102;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getExample();

        Solution solve = new Solution();
        List<List<Integer>> res = solve.levelOrder(root);
        System.out.println(res);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> currentLevel = new ArrayList<>(level);

            for (int i = 0; i < level; i++) {
                TreeNode node = queue.remove();
                currentLevel.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(currentLevel);
        }

        return res;
    }
}
