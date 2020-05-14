package com.github.barskiy.leetcode.problems.narytree.maxdepthofnarytree_559;

import com.github.barskiy.leetcode.problems.narytree.Node;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Solution {

    public int maxDepth(Node root) {
        if (root == null) return 0;

        int res = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Node node = queue.remove();
                List<Node> children = node.children;

                for(Node child: children) {
                    queue.offer(child);
                }
            }
            res++;
        }
        return res;
    }


    public int maxDepthRecursive(Node root) {
        if (root == null) return 0;

        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, maxDepthRecursive(child));
        }

        return 1 + max;
    }
}
