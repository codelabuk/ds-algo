package org.example.ds.leetcode.linkedlist.problem707;

// Time Complexity - O(n)
// Space Complexity - O(1)
class SinglyLinkedList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int a){
            this.val = a;
        }
    }
    private ListNode head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        this.size = 0;
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return  -1;
        }
        ListNode current = head;
        for(int i =0; i < index ; i++){
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if(head ==null){
            head = newNode;
        } else{
            ListNode current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;

    }

    public void addAtIndex(int index, int val) {
        ListNode newNode = new ListNode(val);

        if (index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else {
            ListNode current = head;
            for(int j =0; j< index -1; j++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index > size){
            return;
        }
        if(index == 0){
            head = null;
        } else {
            ListNode current = head;
            for(int i =0; i < index-1; i++){
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
