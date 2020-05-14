package com.github.barskiy.leetcode.problems.narytree.preordertraversal_589;

import com.github.barskiy.leetcode.problems.narytree.Node;

import java.util.*;

public class Solution {

    public List<Integer> preorder(Node root) {
        if (root == null) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (int i = cur.children.size() - 1; i >= 0; i--) {
                stack.push(cur.children.get(i));
            }
            res.add(cur.val);
        }
        return res;
    }


    public List<Integer> res = new ArrayList<>();

    public List<Integer> preorderRecursive(Node root) {
        if (root == null) return res;

        res.add(root.val);
        for (Node child : root.children) {
            preorderRecursive(child);
        }

        return res;
    }
}
