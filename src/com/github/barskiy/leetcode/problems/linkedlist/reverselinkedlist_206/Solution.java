package com.github.barskiy.leetcode.problems.linkedlist.reverselinkedlist_206;

import com.github.barskiy.leetcode.problems.linkedlist.ListNode;

public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        new Solution().reverseListRecursivelyOneMore(l1);
    }

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

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public ListNode reverseListRecursivelyOneMore(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseListRecursivelyOneMore(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

}
