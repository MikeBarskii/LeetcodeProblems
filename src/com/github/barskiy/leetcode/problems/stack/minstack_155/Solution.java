package com.github.barskiy.leetcode.problems.stack.minstack_155;

public class Solution {

    // Time Complexity: O(1)
    // Space Complexity: O(n)
    class MinStack {

        private Node head;

        public void push(int val) {
            if (head == null)
                head = new Node(val, val, null);
            else
                head = new Node(val, Math.min(val, head.min), head);
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }

        public void pop() {
            head = head.next;
        }

        private class Node {
            int val;
            int min;
            Node next;

            public void setNext(Node next) {
                this.next = next;
            }

            public Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
    }
}
