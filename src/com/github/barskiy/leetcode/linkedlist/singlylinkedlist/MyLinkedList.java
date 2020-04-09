package com.github.barskiy.leetcode.linkedlist.singlylinkedlist;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size) return -1;
        if (index == size - 1) return tail.getVal();
        if (index == 0) return head.getVal();

        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.getVal();
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (isEmpty())
            tail = newNode;
        else
            newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (isEmpty()) {
            addAtHead(val);
            return;
        }

        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0)
            addAtHead(val);
        else if (index == size)
            addAtTail(val);
        else {
            Node cur = head;

            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }

            Node newNode = new Node(val);
            newNode.next = cur.next;
            cur.next = newNode;
            size++;
        }
    }

    public void deleteHead() {
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) return;

        if (index == 0) {
            deleteHead();
            return;
        }

        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        if (cur.next == tail)
            tail = cur;

        cur.next = cur.next.next;
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public Node getNext() {
            return next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}