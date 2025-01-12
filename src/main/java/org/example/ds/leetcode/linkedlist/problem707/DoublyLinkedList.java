package org.example.ds.leetcode.linkedlist.problem707;

public class DoublyLinkedList {
    private class ListNode {
        int val;
        ListNode prev, next;

        ListNode(int a) {
            this.val = a;
        }
    }

    private ListNode head, tail;
    int size;

    public DoublyLinkedList() {
        this.tail = null;
        this.head = null;
        this.size = 0;
    }


    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int j = size - 1; j >= size / 2; j--) {
                current = current.prev;
            }
        }

        return current.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        size++;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        newNode.prev = tail;
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index <= 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            ListNode newNode = new ListNode(val);
            ListNode current;
            if (index < size / 2) {
                current = head;
                for (int j = 0; j < index - 1; j++) {
                    current = current.next;
                }
            } else {
                current = tail;
                for (int i = size - 1; i >= size / 2; i--) {
                    current = current.prev;
                }
            }

            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;
            newNode.prev = current;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            if (head.next != null) {
                head = head.next;
                head.prev = null;
            } else {
                head = tail = null;
            }
        } else if (index == size-1) {
            if (tail.prev != null) {
                tail = tail.prev;
                tail.next = null;
            } else {
                head = tail = null;
            }
        } else {
            ListNode current;
            if(index < size/2){
                current = head;
                for(int i=0; i< index; i++){
                    current = current.next;
                }
             } else {
                current = tail;
                for(int j = size-1; j>=size; j--){
                    current = current.prev;
                }
            }

            current.prev.next= current.next;
            current.next.prev = current.prev;
        }
        size--;
    }
}
