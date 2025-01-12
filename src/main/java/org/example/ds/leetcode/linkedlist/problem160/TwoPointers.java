package org.example.ds.leetcode.linkedlist.problem160;

public class TwoPointers {

    ListNode getInterSectionNode(ListNode nodeA, ListNode nodeB){
        if(nodeA == null || nodeB == null){
            return null;
        }
        ListNode a = nodeA;
        ListNode b = nodeB;

        while (a != b){
            a = (a == null) ? nodeB: a.next;
            b = (b == null) ? nodeA : b.next;
        }

        return a;


    }
}
