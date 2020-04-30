package com.github.barskiy.leetcode.problems.stack.maxstack_716;

import java.util.LinkedList;

public class Solution {

    // Time Complexity: O(n) for popMax(), O(1) for other operations
    // Space Complexity: O(n)
    class MaxStack {
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> maxes = new LinkedList<>();

        public void push(int x) {
            stack.push(x);
            if (maxes.isEmpty())
                maxes.push(x);
            else
                maxes.push(Math.max(maxes.peek(), x));
        }

        public int pop() {
            maxes.pop();
            return stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return maxes.peek();
        }

        public int popMax() {
            int max = peekMax();
            LinkedList<Integer> temp = new LinkedList<>();
            while (top() != max)
                temp.push(pop());
            pop();
            while (!temp.isEmpty())
                push(temp.pop());
            return max;
        }
    }
}
