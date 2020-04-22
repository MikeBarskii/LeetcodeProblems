package com.github.barskiy.leetcode.problems.queue.designcircularqueue_622;

public class MyCircularQueue {

    private final int[] queue;

    private int size;
    private final int capacity;

    private int head;
    private int tail;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        queue = new int[k];
        capacity = k;
        size = 0;
        head = 0;
        tail = -1;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        tail = (tail + 1) % capacity;
        queue[tail] = value;
        size++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) return false;
        head++;
        size--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return (isEmpty()) ? -1 : queue[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        return (isEmpty()) ? -1 : queue[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }}
