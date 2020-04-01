package com.github.barskiy.linkedlist.singlylinkedlist.classicproblems;

import com.github.barskiy.linkedlist.singlylinkedlist.twopointerproblems.LinkedListCycle.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = head;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            head.next = nextNode.next;
            nextNode.next = prev;
            prev = nextNode;
            nextNode = head.next;
        }

        return prev;
    }
}
