package org.example1.practice.linkedlist.doubly;

public class DoublyLInkedListTraversal {

    public static void main(String[] args) {

        Node doublYNode = convertFromList();
        printElement(doublYNode);

        Node deletedNode = deleteAtHead(doublYNode);
        printElement(deletedNode);

        Node deletedTail = deleteAtTail(convertFromList());
        printElement(deletedTail);

        Node deletedKthTail = deleteKthElement(convertFromList(), 4);
        printElement(deletedKthTail);

        Node newHead = insertBeforeHead(convertFromList(), 9);
        printElement(newHead);

        Node newTail = insertBeforeTail(convertFromList(), 9);
        printElement(newTail);

        Node newKthElement = insertBeforeKthElement(convertFromList(), 3, 7);
        printElement(newKthElement);
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

    private static Node insertBeforeHead(Node head, int value) {
        Node node = new Node(value, null, head);
        head.back = node;
        return node;
    }

    private static Node insertBeforeTail(Node head, int val) {
        if (head.next == null) {
            return insertBeforeHead(head, val);
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        Node prev = tail.back;
        Node newNode = new Node(val, prev, tail);
        prev.next = newNode;
        tail.back = newNode;

        return head;
    }

    private static Node insertBeforeKthElement(Node head, int k, int val) {
        if (k == 1) {
            return insertBeforeHead(head, val);
        }
        Node temp = head;
        int count = 0;
        while (temp.next != null) {
            count++;
            if (count == k) break;
            temp = temp.next;
        }
        Node prev = temp.back;
        Node newNode = new Node(val, prev , temp);
        prev.next = newNode;
        temp.back = newNode;
        return head;
    }
}
