package org.example1.practice.linkedlist.singly;

import java.util.Stack;

public class ReverseLinkedListv1 {

    public static void main(String[] args) {
        final int[] var = new int[]{1, 3, 5, 7};
        Node llNodes = fromList(var);
        print(llNodes);
        print(reverseLLBruteForce1(llNodes));
        Node llNodes1 = fromList(var);
        print(reverseInIteration1(llNodes1));
        Node llNodes2 = fromList(var);
        print(reverseInRecursion(llNodes2));

    }

    private static Node reverseInRecursion(Node head) {
        if (head == null || head.next == null) return head;
        Node newNode = reverseInRecursion(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newNode;

    }

    private static Node reverseInIteration1(Node head) {
        if (head == null || head.next == null) return head;
        Node temp = head, prev = null;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;

    }

    private static Node reverseLLBruteForce1(Node head) {
        Node temp = head;
        Stack<Integer> integerStack = new Stack<>();
        while (temp != null) {
            integerStack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = integerStack.pop();
            temp = temp.next;
        }
        return head;

    }


    static Node fromList(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    private static void print(Node node) {
        while (node != null) {
            System.out.print(node.data + (node.next != null ? " " : ""));
            node = node.next;
        }
        System.out.println();
    }


}
