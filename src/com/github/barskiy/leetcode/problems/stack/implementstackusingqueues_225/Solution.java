package com.github.barskiy.leetcode.problems.stack.implementstackusingqueues_225;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    class MyStack {

        Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = new ArrayDeque<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.offer(x);
            int size = queue.size();
            while (size > 1) {
                queue.offer(queue.remove());
                size--;
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.element();
        }

        /** Get the top element. */
        public int top() {
            return queue.element();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
