package org.example.ds;

import java.util.List;

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        next = null;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }

    public void removeCycle(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                hasCycle = true;
                break;
            }
        }

        if(!hasCycle){
            return;
        }

        slow = head;
        ListNode prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;


    }

}


public class ListNodeSolution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = null;

        System.out.println("" + head.hasCycle(head));

    }
}
