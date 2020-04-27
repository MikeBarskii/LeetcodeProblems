package com.github.barskiy.leetcode.problems.binarytree.populatingnextrightpointersineachnode_117;

public class Solution {

    public Node connect(Node root) {
        connectHelper(root);
        return root;
    }

    private void connectHelper(Node root) {
        while (root != null) {
            Node cur = root;
            while (cur != null) {

                if (cur.left != null) {
                    if (cur.right != null)
                        cur.left.next = cur.right;
                    else
                        cur.left.next = getNextForChild(root.next);
                }

                if (cur.right != null)
                    cur.right.next = getNextForChild(root.next);

                cur = cur.next;
            }
            root = root.left;
        }
    }

    private Node getNextForChild(Node next) {
        while (next != null) {
            if (next.left != null)
                return next.left;
            else if (next.right != null)
                return next.right;
            next = next.next;
        }

        return null;
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

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
