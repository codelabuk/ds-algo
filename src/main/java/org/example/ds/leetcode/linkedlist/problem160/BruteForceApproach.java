package org.example.ds.leetcode.linkedlist.problem160;
// Leetcode 160: Intersection of Two Linked Lists
// Time Complexity - O(m*n) Space Complexity - O(1) due to
public class BruteForceApproach {

    public ListNode getInterSectionNode(ListNode nodeA, ListNode nodeB){
        ListNode a = nodeA;
        while (a != null){
            ListNode b = nodeB;
            while (b != null){
                if(a == b){
                    return a;
                }
                b = b.next;
            }
            a = a.next;
        }
        return null; // No InterSection found
    }
}
