package com.github.barskiy.leetcode.problems.stack.onlinestockspan_901;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        stockSpanner.next(100);
        stockSpanner.next(80);
        stockSpanner.next(60);
        stockSpanner.next(70);
        stockSpanner.next(60);
        stockSpanner.next(75);
        stockSpanner.next(85);
    }

    static class StockSpanner {
        Deque<Stock> stack;

        public StockSpanner() {
            stack = new ArrayDeque<>();
        }

        public int next(int price) {
            int index = 1;
            while (!stack.isEmpty() && stack.peek().price <= price)
                index += stack.poll().index;
            stack.push(new Stock(index, price));
            return index;
        }

        private class Stock {
            int index;
            int price;

            public Stock(int index, int price) {
                this.index = index;
                this.price = price;
            }
        }
    }
}
