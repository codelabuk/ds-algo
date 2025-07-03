package org.example1.practice.linkedlist.doubly;

public class DoublyLInkedListTraversal {

    public static void main(String[] args) {

        Node doublYNode = convertFromList();
        printElement(doublYNode);

        Node deletedNode = deleteAtHead(doublYNode);
        printElement(deletedNode);

        Node deletedTail = deleteAtTail(convertFromList());
        printElement(deletedTail);

        Node deletedKthTail = deleteKthElement(convertFromList() , 4);
        printElement(deletedKthTail);

    }

    private static Node convertFromList() {

        final int[] arr = new int[]{1, 4, 2, 5, 6};

        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], prev, null);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static void printElement(Node head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();

    }

    private static Node deleteAtHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        head.back = null;
        return head;
    }

    private static Node deleteAtTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        Node prev = tail.back;
        prev.next = null;
        tail.back = null;

        return head;
    }


    private static Node deleteKthElement(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node kNode = head;
        int count = 0;
        while (kNode != null) {
            count++;
            if (count == k) break;
            kNode = kNode.next;
        }
        Node prev = kNode.back;
        Node front = kNode.next;
        // only 1 element
        if (prev == null && front == null) {
            return null;
        }
        // position at front
        if (prev == null) {
            return deleteAtHead(kNode);
        }
        // position at tail
        if (front == null) {
            return deleteAtTail(kNode);
        }
        // mid element
        prev.next = front;
        front.back = prev;
        kNode.next = null;
        kNode.back = null;
        return head;
    }
}
