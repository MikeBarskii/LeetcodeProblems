package com.github.barskiy.leetcode.problems.binarytree.populatingnextrightpointersineachnode_116;


class Solution {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public Node connectIterative(Node root) {
        if (root == null) return null;
        connectIterativeHelper(root);
        return root;
    }

    private void connectIterativeHelper(Node root) {
        while (root != null) {
            Node cur = root;
            while (cur != null) {
                if (cur.left != null) cur.left.next = cur.right;
                if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;

                cur = cur.next;
            }
            root = root.left;
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) root.left.next = root.right;
        connect(root.left);
        connect(root.right);

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}