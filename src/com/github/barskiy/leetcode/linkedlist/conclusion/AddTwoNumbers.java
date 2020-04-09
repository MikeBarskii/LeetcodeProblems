package com.github.barskiy.leetcode.linkedlist.conclusion;

import com.github.barskiy.leetcode.linkedlist.singlylinkedlist.twopointerproblems.LinkedListCycle.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
        ListNode dummy = cur;
        int remain = 0;

        while (l1 != null && l2 != null) {
            int nodeValue = (remain + l1.val + l2.val) % 10;
            remain = (remain + l1.val + l2.val) / 10;

            cur.next = new ListNode(nodeValue);

            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode remainListNode = (l1 == null) ? l2 : l1;

        while (remain != 0 || remainListNode != null) {
            int nodeValue = (remainListNode == null) ? 0 : remainListNode.val;
            cur.next = new ListNode((remain + nodeValue) % 10);
            cur = cur.next;
            remain = (remain + nodeValue) / 10;
            remainListNode = (remainListNode == null) ? null : remainListNode.next;
        }

        return dummy.next;
    }

    public ListNode addTwoNumbersLeetCode(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
        ListNode dummy = cur;

        int sum = 0;
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        if (sum / 10 == 1)
            cur.next = new ListNode(1);

        return dummy.next;
    }
}
