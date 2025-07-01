package org.example1.practice.linkedlist.doubly;

public class DoublyLInkedListTraversal {

    public static void main(String[] args) {

        Node doublYNode = convertFromList();
        printElement(doublYNode);

        Node deletedNode = deleteAtHead(doublYNode);
        printElement(deletedNode);

        Node deletedTail = deleteAtTail(convertFromList());
        printElement(deletedTail);

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
        head.prev = null;
        return head;
    }

    private static Node deleteAtTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node tail = head;
        while (tail.next != null){
            tail = tail.next;
        }

        Node prev = tail.prev;
        prev.next = null;
        tail.prev = null;

        return head;
    }
}
