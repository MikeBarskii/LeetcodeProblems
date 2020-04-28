package com.github.barskiy.leetcode.problems.linkedlist.addtwonumbers_2;

import com.github.barskiy.leetcode.problems.linkedlist.ListNode;

public class Solution {

    // Time Complexity: O(max(m, n))
    // Space Complexity: O(max(m, n))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        int remain = 0;
        while (p1 != null || p2 != null) {

            int sum = ((p1 == null) ? 0 : p1.val) +
                    ((p2 == null) ? 0 : p2.val) + remain;

            cur.next = new ListNode(sum % 10);
            remain = sum / 10;

            cur = cur.next;
            p1 = (p1 == null) ? null : p1.next;
            p2 = (p2 == null) ? null : p2.next;
        }

        if (remain != 0)
            cur.next = new ListNode(remain);

        return dummy.next;
    }
}
