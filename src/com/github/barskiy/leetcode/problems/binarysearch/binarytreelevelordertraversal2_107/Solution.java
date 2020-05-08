package com.github.barskiy.leetcode.problems.binarysearch.binarytreelevelordertraversal2_107;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

import java.util.*;

public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();

        Queue<TreeNode> queue = new ArrayDeque<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();

                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

                size--;
            }
            res.addFirst(level);
        }

        return res;
    }
}
