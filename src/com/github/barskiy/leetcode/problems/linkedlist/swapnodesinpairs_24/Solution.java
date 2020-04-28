package com.github.barskiy.leetcode.problems.linkedlist.swapnodesinpairs_24;

import com.github.barskiy.leetcode.problems.linkedlist.ListNode;

public class Solution {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);

        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            prev.next = next;

            prev = cur;
            cur = cur.next;
        }

        return dummy.next;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public ListNode swapPairsRecursively(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        head.next = next.next;
        next.next = head;

        head.next = swapPairsRecursively(head.next);
        return next;
    }
}
