package org.example.ds.leetcode.linkedlist.problem160;

import java.util.HashSet;
// Time complexity - O(m+n)
public class UsingHashSet {

    public ListNode getInterSectionNode(ListNode nodeA, ListNode nodeB){
        HashSet<ListNode> hashNode = new HashSet<>();
        ListNode b = nodeB;
        while(b != null){
            hashNode.add(b);
            nodeA = b.next;
        }

        ListNode a = nodeA;
        while (a != null){
            if(hashNode.contains(a)){
                return a;
            }
            a = a.next;
        }

        return  null;
    }
}
