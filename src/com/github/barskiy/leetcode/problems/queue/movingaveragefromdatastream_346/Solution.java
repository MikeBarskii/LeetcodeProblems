package com.github.barskiy.leetcode.problems.queue.movingaveragefromdatastream_346;

public class Solution {

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(3);
        System.out.println(ma.next(1));
        System.out.println(ma.next(10));
        System.out.println(ma.next(3));
        System.out.println(ma.next(5));
    }

    static class MovingAverage {
        int[] nums;
        int pos;
        int sum;
        int size;

        MovingAverage(int capacity) {
            nums = new int[capacity];
            size = pos = sum = 0;
        }

        double next(int val) {
            sum -= nums[pos];
            nums[pos] = val;
            pos = (pos + 1) % nums.length;

            sum += val;

            if (size < nums.length) size++;
            return (double) sum / size;
        }
    }
}
