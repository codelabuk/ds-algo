package org.example1.practice.linkedlist.doubly;

public class Node {
    int data;
    Node next;
    Node back;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }

    Node(int data, Node back, Node next) {
        this.data = data;
        this.next = next;
        this.back = back;
    }
}

