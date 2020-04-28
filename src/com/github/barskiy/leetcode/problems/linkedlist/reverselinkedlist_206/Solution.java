package com.github.barskiy.leetcode.problems.linkedlist.reverselinkedlist_206;

import com.github.barskiy.leetcode.problems.linkedlist.ListNode;

public class Solution {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
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

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public ListNode reverseListRecursively(ListNode head) {
        return reverseRecursiveHelper(head, null);
    }

    private ListNode reverseRecursiveHelper(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseRecursiveHelper(next, head);
    }
}
