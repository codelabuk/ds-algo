package org.example1.practice.linkedlist.singly;


public class MergeSortedDescending {

    static Node merge(Node head1, Node head2) {
        Node result = null;
        while (head1 != null && head2 != null) {
            Node temp;
            if (head1.data > head2.data) {
                temp = head2;
                head2 = head2.next;
            } else {
                temp = head1;
                head1 = head1.next;
            }

            temp.next = result;
            result = temp;
        }

        while (head1 != null) {
            Node temp = head1;
            head1 = head1.next;
            temp.next = result;
            result = temp;
        }

        while (head2 != null) {
            Node temp = head2;
            head2 = head2.next;
            temp.next = result;
            result = temp;
        }
        return result;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // List 1: 5 -> 10 -> 11 -> 20
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(11);
        head1.next.next.next = new Node(20);

        // List 2: 4 -> 25 -> 30
        Node head2 = new Node(4);
        head2.next = new Node(25);
        head2.next.next = new Node(30);

        Node result = merge(head1, head2);
        printList(result); // 30 -> 25 -> 20 -> 11 -> 10 -> 5 -> 4 -> null


        // List 1: 10 -> 5 -> 20 -> 11
        Node head3 = new Node(10);
        head3.next = new Node(5);
        head3.next.next = new Node(20);
        head3.next.next.next = new Node(11);

        // List 2: 25 -> 4 -> 30
        Node head4 = new Node(25);
        head4.next = new Node(4);
        head4.next.next = new Node(30);

        System.out.println();
        Node result1 = merge(head3, head4);
        printList(result1); // 30 -> 25 -> 20 -> 11 -> 10 -> 5 -> 4 -> null

    }
}
