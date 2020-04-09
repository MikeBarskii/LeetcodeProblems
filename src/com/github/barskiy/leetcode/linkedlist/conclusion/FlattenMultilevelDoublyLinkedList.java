package com.github.barskiy.leetcode.linkedlist.conclusion;

public class FlattenMultilevelDoublyLinkedList {

    public Node flatten(Node head) {
        if (head == null) return null;
        flatten(head.prev, head);
        return head;
    }

    private Node flatten(Node prev, Node head) {
        if (head == null) return prev;
        if (prev != null)
            prev.next = head;
        head.prev = prev;
        Node newHead = null;
        Node next = head.next;
        if (head.child != null) {
            newHead = flatten(head, head.child);
            head.child = null;
        }
        return flatten((newHead == null) ? head : newHead, next);
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}

