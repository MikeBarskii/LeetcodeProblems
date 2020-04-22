package com.github.barskiy.leetcode.problems.queue.designcircularqueue_622;

public class Solution {

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(6);
        circularQueue.enQueue(6);
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.deQueue());
        circularQueue.enQueue(5);
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.Front());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
    }
}
