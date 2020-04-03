package com.github.barskiy.linkedlist.singlylinkedlist.classicproblems;

import com.github.barskiy.linkedlist.singlylinkedlist.twopointerproblems.LinkedListCycle.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null && cur.next != null) {
            ListNode nextNode = cur.next;
            cur.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
            prev = nextNode;
            cur = cur.next;
        }

        return head;
    }

    public ListNode oddEvenListSolutionByLeetCode(ListNode head) {
        if (head == null)
            return null;

        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode p = new ListNode(1);
    }
}
