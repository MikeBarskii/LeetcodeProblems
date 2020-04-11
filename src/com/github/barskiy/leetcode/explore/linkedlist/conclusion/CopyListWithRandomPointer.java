package com.github.barskiy.leetcode.explore.linkedlist.conclusion;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> nodeToCopy = new HashMap<>();

        Node cur = head;
        while (cur != null) {
            nodeToCopy.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node copyNode = nodeToCopy.get(cur);
            Node nextCopyNode = nodeToCopy.get(cur.next);
            Node randomCopyNode = (cur.random == null) ? null : nodeToCopy.get(cur.random);
            copyNode.next = nextCopyNode;
            copyNode.random = randomCopyNode;
            cur = cur.next;
        }
        return nodeToCopy.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

    }
}
