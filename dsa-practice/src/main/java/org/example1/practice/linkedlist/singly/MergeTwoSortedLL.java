package org.example1.practice.linkedlist.singly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.example1.practice.linkedlist.singly.LinkedListTraversal.printElement;

public class MergeTwoSortedLL {

    private static Node bruteForce(Node head1, Node head2) {
        List<Integer> aList = new ArrayList<>();
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null) {
            aList.add(temp1.data);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            aList.add(temp2.data);
            temp2 = temp2.next;
        }
        Collections.sort(aList);
        Node node = convertFromList((Integer[]) aList.toArray());
        return node;
    }

    private static Node optimal(Node head1, Node head2) {
        Node t1 = head1, t2 = head2;
        Node dNode = new Node(-1);
        Node temp = dNode;

        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }
        if (t1 != null) {
            temp.next = t1;
        } else {
            temp.next = t2;
        }
        return  dNode.next;
    }


    private static Node convertFromList(Integer[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }


    public static void main(String[] args) {
        final int[] arr1 = new int[]{1, 3, 4, 5, 7};
        final int[] arr2 = new int[]{2, 6, 8, 9};
        Node head1 = LinkedListTraversal.convertFromList(arr1);
        Node head2 = LinkedListTraversal.convertFromList(arr2);
        printElement(optimal(head1, head2));
    }
}
