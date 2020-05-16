package com.github.barskiy.leetcode.problems.linkedlist.reversenodesinkgroup_25;

import com.github.barskiy.leetcode.problems.linkedlist.ListNode;

public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        Solution solve = new Solution();
        ListNode res = solve.reverseKGroup(l1, 3);
        System.out.println(res);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;

        ListNode dummy = new ListNode(-1);
        ListNode lastPreviousGroupNode = dummy;
        ListNode prev, next, cur = head;
        while (cur != null) {
            ListNode endOfGroupNode = movePointerToNStepsForward(cur, k);
            if (endOfGroupNode == null) break;

            prev = cur;
            next = cur.next;

            while (prev != endOfGroupNode) {
                cur.next = next.next;
                next.next = prev;
                prev = next;
                next = cur.next;
            }

            lastPreviousGroupNode.next = prev;
            lastPreviousGroupNode = cur;
            cur = next;
        }

        return dummy.next;
    }

    private ListNode movePointerToNStepsForward(ListNode pointer, int k) {
        for (int i = 1; i < k && pointer != null; i++) {
            pointer = pointer.next;
        }
        return pointer;
    }

/*    private ListNode swapGroupAndReturnLastElement(ListNode head, int groupSize) {
        ListNode prev = head;
        ListNode next = head.next;
        for (int i = 1; i < groupSize; i++) {
            while (next != null) {
                head.next = next.next;
                next.next = prev;
                prev = next;
                next = head.next;
            }
        }
        return head;
    }*/
}
