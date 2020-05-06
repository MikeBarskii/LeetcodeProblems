package com.github.barskiy.leetcode.problems.stack.implementqueueusingstacks_232;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    class MyQueue {

        Deque<Integer> inputStack;
        Deque<Integer> outputStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            inputStack = new ArrayDeque<>();
            outputStack = new ArrayDeque<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            inputStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (outputStack.isEmpty())
                moveFromInputToOutputStack();
            return outputStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (outputStack.isEmpty())
                moveFromInputToOutputStack();
            return outputStack.remove();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return inputStack.isEmpty() && outputStack.isEmpty();
        }

        private void moveFromInputToOutputStack() {
            while (!inputStack.isEmpty())
                outputStack.push(inputStack.pop());
        }
    }
}
