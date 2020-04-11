package com.github.barskiy.leetcode.explore.linkedlist.conclusion;

import com.github.barskiy.leetcode.explore.linkedlist.singlylinkedlist.twopointerproblems.LinkedListCycle.ListNode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ListNode v1 = new ListNode(1);
        ListNode v2 = new ListNode(3);
        ListNode v3 = new ListNode(4);
        v1.next = v2;
        v2.next = v3;

        mergeTwoLists(l1, v1);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
        ListNode dummy = cur;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 == null)
            cur.next = l2;

        if (l2 == null)
            cur.next = l1;

        return dummy.next;
    }

}
