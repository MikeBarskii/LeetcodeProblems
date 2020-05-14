package com.github.barskiy.leetcode.problems.narytree.levelordertraversal_429;

import com.github.barskiy.leetcode.problems.narytree.Node;

import java.util.*;

public class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                Node current = queue.remove();
                level.add(current.val);
                for (Node child : current.children) {
                    queue.offer(child);
                }
            }
            res.add(level);
        }
        return res;
    }

}
