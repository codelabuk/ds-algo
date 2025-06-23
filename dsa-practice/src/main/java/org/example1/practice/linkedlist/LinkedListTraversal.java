package org.example1.practice.linkedlist;

public class LinkedListTraversal {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};

        System.out.println("Remove at head ====");
        Node head = convertToLinkedList(arr);
        printNodes(head);
        System.out.println(lengthOfLinkedList(head));
        System.out.println(checkIfPresent(head, 3));

        Node newHead = removeAtHead(head);
        printNodes(newHead);

        System.out.println("Remove at tail ====");
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        Node head1 = convertToLinkedList(arr1);
        printNodes(head1);
        Node nodes = removeAtTail(head1);
        printNodes(nodes);

        System.out.println("Remove at K position ====");
        int[] arr2 = new int[]{5, 2, 3, 8, 1};
        Node head2 = convertToLinkedList(arr2);
        Node node = removeAtPosition(head2, 4);
        printNodes(node);

        System.out.println("Remove at K element ====");
        int[] arr3 = new int[]{5, 2, 3, 8, 1};
        Node head3 = convertToLinkedList(arr3);
        Node node1 = removeElement(head3, 4);
        printNodes(node1);

        System.out.println("Insert  at head ====");
        Node insertNode = insertAtHead(head3, 15);
        printNodes(insertNode);

        System.out.println("Insert  at Tail ====");
        Node insertNodeTail = insertAtTail(head3, 18);
        printNodes(insertNodeTail);
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

    /**
     * Time Complexity - O(k)
     *
     * @param head
     * @param k
     * @return
     */
    private static Node removeAtPosition(Node head, int k) {
        if (head == null) {
            return head;
        }
        if (k == 1) {
            head = head.next;
            return head;
        }
        int count = 0;
        Node temp = head, prev = null;
        while (temp != null) {
            count++;
            if (count == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }


    private static Node removeElement(Node head, int k) {
        if (head == null) return null;
        if (head.data == k) {
            head = head.next;
            return head;
        }

        Node temp = head, prev = null;
        while (temp != null) {
            if (temp.data == k) {
                prev.next = prev.next.next;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node insertAtHead(Node head, int value){
        Node temp = new Node(value);
        temp.next = head;
        return  temp;
    }

    private static Node insertAtTail(Node head, int value){
        if(head == null){
            return new Node(value);
        }
        Node temp = head;
        while(temp.next != null){
          temp = temp.next;
        }
        temp.next =  new Node(value);
        return  head;
    }

}
