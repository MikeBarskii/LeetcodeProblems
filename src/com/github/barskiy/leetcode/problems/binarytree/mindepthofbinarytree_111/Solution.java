package com.github.barskiy.leetcode.problems.binarytree.mindepthofbinarytree_111;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public int minDepthBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode cur = queue.poll();

                if (cur.left == null && cur.right == null)
                    return ++depth;

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);

                size--;
            }
            depth++;
        }

        return depth;
    }

    public int minDepthDFS(TreeNode root) {
        if (root == null) return 0;

        int left = minDepthDFS(root.left);
        int right = minDepthDFS(root.right);

        int res;
        if (left == 0) res = right;
        else if (right == 0) res = left;
        else res = Math.min(left, right);

        return 1 + res;
    }
}
