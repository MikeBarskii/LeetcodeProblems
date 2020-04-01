package com.github.barskiy.linkedlist.singlylinkedlist.twopointerproblems;

import com.github.barskiy.linkedlist.singlylinkedlist.twopointerproblems.LinkedListCycle.ListNode;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != null || p2 != null) {
            if (p2 == null) p2 = headA;
            if (p1 == null) p1 = headB;
            if (p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
