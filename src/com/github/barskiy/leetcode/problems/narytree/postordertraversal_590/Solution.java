package com.github.barskiy.leetcode.problems.narytree.postordertraversal_590;

import com.github.barskiy.leetcode.problems.narytree.Node;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        List<Node> children2 = new ArrayList<>();
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        children2.add(node5);
        children2.add(node6);
        Node node3 = new Node(3, children2);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        List<Node> children1 = new ArrayList<>();
        children1.add(node3);
        children1.add(node2);
        children1.add(node4);
        Node node1 = new Node(1, children1);

        Solution solve = new Solution();
        System.out.println(solve.postorder(node1));
    }

    public List<Integer> postorder(Node root) {
        if (root == null) return Collections.emptyList();

        LinkedList<Integer> res = new LinkedList<>();
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            node.children.forEach(stack::push);
            res.addFirst(node.val);
        }
        return res;
    }
}
