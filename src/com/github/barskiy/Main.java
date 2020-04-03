package com.github.barskiy;

public class Main {

    public static void main(String[] args) {
//        MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
//        System.out.println(linkedList.get(1));
//        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
//        System.out.println(linkedList.get(1));

        int[] arr = {4, 4,1};
        int number = 0;
        for (int i : arr) number = number ^ i;
        System.out.println(number);
    }
}
