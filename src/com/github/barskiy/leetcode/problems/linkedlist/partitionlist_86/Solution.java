package com.github.barskiy.leetcode.problems.linkedlist.partitionlist_86;

import com.github.barskiy.leetcode.problems.linkedlist.ListNode;

public class Solution {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode root4 = new ListNode(2);
        ListNode root3 = new ListNode(3);
        ListNode root2 = new ListNode(4);
        ListNode root5 = new ListNode(5);
        root.next = root4;
        root4.next = root3;
        root3.next = root2;
        root2.next = root5;
//        root5.next = new ListNode(2);

        Solution solve = new Solution();
        ListNode res = solve.partition(root, 3);
        System.out.println(res);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevInsert = dummy;
        if (head.val < x) prevInsert = head;

        ListNode prev = head, cur = head;
        while (cur != null && cur.val >= x) {
            prev = cur;
            cur = cur.next;
        }

        if (cur == null) return head;

        while (cur != null) {


            if (cur == null)
                return dummy.next;

            prev.next = cur.next;
            ListNode temp = prevInsert.next;
            prevInsert.next = cur;
            cur.next = temp;
            prevInsert = cur;
            cur = prev.next;
        }

        return dummy.next;
    }
}
