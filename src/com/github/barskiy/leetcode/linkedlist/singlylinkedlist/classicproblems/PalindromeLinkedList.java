package com.github.barskiy.leetcode.linkedlist.singlylinkedlist.classicproblems;

import com.github.barskiy.leetcode.linkedlist.singlylinkedlist.twopointerproblems.LinkedListCycle.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reversed(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private ListNode reversed(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
