package com.github.barskiy.linkedlist.conclusion;

import com.github.barskiy.linkedlist.singlylinkedlist.twopointerproblems.LinkedListCycle.ListNode;

public class RotateList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;

//        rotateRight(l1, 1);
        rotateRight(l1, 5);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ListNode pointer = head;
        int size = 1;
        while (pointer.next != null) {
            pointer = pointer.next;
            size++;
        }

        int rotateNumber = k % size;
        if (rotateNumber == 0 || size == 1)
            return head;

        pointer.next = head;
        for (int i = 1; i < size - rotateNumber; i++)
            head = head.next;

        ListNode newHead = head.next;
        head.next = null;

        return newHead;
    }
}
