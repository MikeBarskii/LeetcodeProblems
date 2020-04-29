package com.github.barskiy.leetcode.problems.linkedlist.mergetwosortedlists_21;

import com.github.barskiy.leetcode.problems.linkedlist.ListNode;


public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l5;
        l5.next = l6;


        ListNode v1 = new ListNode(1);
        ListNode v2 = new ListNode(3);
        ListNode v3 = new ListNode(4);
        v1.next = v2;
        v2.next = v3;

        ListNode res = new Solution().mergeTwoListsRecursively(l1, v1);
        System.out.println(res);
    }

    // Time Complexity: O(min(n,m))
    // Space Complexity: O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    // Time Complexity: O(n + m)
    // Space Complexity: O(min(n, m))
    // Tail Recursion
    public ListNode mergeTwoListsRecursively(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        mergeTwoListsRecursiveHelper(dummy, l1, l2);
        return dummy.next;
    }

    private void mergeTwoListsRecursiveHelper(ListNode cur, ListNode l1, ListNode l2) {
        if (l1 == null) {
            cur.next = l2;
            return;
        } else if (l2 == null) {
            cur.next = l1;
            return;
        }

        if (l1.val <= l2.val) {
            cur.next = l1;
            l1 = l1.next;
        } else {
            cur.next = l2;
            l2 = l2.next;
        }
        mergeTwoListsRecursiveHelper(cur.next, l1, l2);
    }
}
