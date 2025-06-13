package org.example1.practice.linkedlist;

public class LinkedListTraversal {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        
        Node head = convertToLinkedList(arr);
        printNodes(head);
    }

    private static Node convertToLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i =1 ; i < arr.length; i++){
            Node temp =  new Node(arr[i]);
             mover.next = temp;
             mover = temp;
        }

        return  head;

    }

    private  static void  printNodes(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
