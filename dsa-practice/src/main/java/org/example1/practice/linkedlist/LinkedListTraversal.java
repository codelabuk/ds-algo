package org.example1.practice.linkedlist;

public class LinkedListTraversal {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};

        Node head = convertToLinkedList(arr);
        printNodes(head);
        System.out.println(lengthOfLinkedList(head));
        System.out.println(checkIfPresent(head, 3));

        Node newHead = removeAtHead(head);
        System.out.println("removed at head");
        printNodes(newHead);
        System.out.println("New List ====");
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        Node head1 = convertToLinkedList(arr1);
        printNodes(head1);
        Node nodes = removeAtTail(head1);
        System.out.println("Removed at tail");
        printNodes(nodes);
    }


    private static Node convertToLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;

    }

    private static void printNodes(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static int lengthOfLinkedList(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    private static boolean checkIfPresent(Node head, int data) {
        while (head != null) {
            if (head.data == data) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    private static Node removeAtHead(Node head) {
        if (head == null) return head;
        head = head.next;
        return head;
    }


    private static Node removeAtTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }


}
