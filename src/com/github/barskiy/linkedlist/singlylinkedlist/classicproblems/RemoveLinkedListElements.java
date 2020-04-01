package com.github.barskiy.linkedlist.singlylinkedlist.classicproblems;

import com.github.barskiy.linkedlist.singlylinkedlist.twopointerproblems.LinkedListCycle.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;

        while (cur.next != null) {
            if (cur.next.val == val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }

        return dummy.next;
    }
}
