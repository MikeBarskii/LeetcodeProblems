package com.github.barskiy.leetcode.problems.binarysearchtree.binarysearchiterator_173;

import com.github.barskiy.leetcode.problems.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode node15 = new TreeNode(15);
        root.left = new TreeNode(3);
        root.right = node15;
        node15.left = new TreeNode(9);
        node15.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }

    static class BSTIterator {

        Deque<TreeNode> stack;
        TreeNode cur;

        public BSTIterator(TreeNode root) {
            stack = new ArrayDeque<>();
            cur = root;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return getNext().val;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }

        private TreeNode getNext() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            TreeNode res = cur;
            cur = cur.right;
            return res;
        }
    }
}
