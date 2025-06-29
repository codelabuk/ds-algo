package org.example1.practice.linkedlist.singly;

public class LinkedListTraversal {

    public static void main(String[] args) {
        final int[] arr = new int[]{1, 4, 5, 7, 3};
        Node head = convertFromList(arr);
        printElement(head);

        System.out.println(checkIfPresent(head, 7));

        //remove At head

        Node removedHead = removeAtHead(head);
        printElement(removedHead);

        //remove at tail
        Node removedNodeAtTail = removeAtTail(head);
        printElement(removedNodeAtTail);

        // remove at position
        Node head1 = convertFromList(arr);
        Node removeATPos = removeAtKPosition(head1, 3);
        printElement(removeATPos);
        // remove element by data
        Node head2 = convertFromList(arr);
        Node removeByData = removeElementByData(head2, 4);
        printElement(removeByData);

        Node head3 = convertFromList(arr);
        Node addedNodeAtHead = insertELementAtHead(head3, 9);
        printElement(addedNodeAtHead);

        Node head4 = convertFromList(arr);
        Node addedNodeAtHead1 = insertELementAtTail(head4, 9);
        printElement(addedNodeAtHead1);

        Node head5 = convertFromList(arr);
        Node addedNodeAtHead2 = insertELementAtKPosition(head5, 11, 4);
        printElement(addedNodeAtHead2);

        Node head6 = convertFromList(arr);
        Node addedNodeAtHead3 = insertELementAfter(head6, 11, 4);
        printElement(addedNodeAtHead3);


    }

    private static Node convertFromList(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
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

    private static boolean checkIfPresent(Node head, int data) {
        while (head != null) {
            if (head.data == data) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


    private static Node removeAtHead(Node node) {
        if (node == null || node.next == null) return node;

        Node head = node;
        head = head.next;
        return head;
    }

    private static Node removeAtTail(Node head) {
        if (head == null || head.next == null) return null;

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }

    private static Node removeAtKPosition(Node head, int k) {
        if (head == null) return null;
        if (k == 1) {
            head = head.next;
            return head;
        }

        Node temp = head, prev = null;
        int count = 0;
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

    private static Node removeElementByData(Node head, int data) {
        if (head == null) return null;
        if (head.data == data) {
            return head;
        }
        Node temp = head, prev = null;
        while (temp != null) {
            if (temp.data == data) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;

    }

    private static Node insertELementAtHead(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) return temp;

        temp.next = head;

        return temp;
    }

    private static Node insertELementAtTail(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return head;
    }

    private static Node insertELementAtKPosition(Node head, int data, int k) {
        if (head == null) {
            if (k == 1) {
                return new Node(data);
            } else {
                return null;
            }
        }
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == k) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }


    private static Node insertELementAfter(Node head, int data, int existinData) {
        if (head == null) {
            return null;
        }

        if (head.data == existinData) {
            Node newNode = new Node(data);
            newNode.next = head;
            return newNode;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == existinData) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }


}
