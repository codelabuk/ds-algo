package org.example1.practice.linkedlist.singly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example1.practice.linkedlist.singly.LinkedListTraversal.printElement;

public class MergeKSortedLL {

    private static Node bruteForce(List<Node> lists) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            Node temp = lists.get(i);
            while (temp != null) {
                arr.add(temp.data);
                temp = temp.next;
            }
        }
        arr.sort(Integer::compare);
        return convertFromList(arr);
    }

    public static Node convertFromList(List<Integer> list){
        Node head = new Node(list.get(0));
        Node temp = head;
        for(int i = 1; i < list.size(); i++){
            temp.next = new Node(list.get(i));
            temp = temp.next;
        }
        return head;
    }


    public static void main(String[] args) {
        List<Integer> arr1= Arrays.asList(1, 3, 4, 5, 7);
        List<Integer> arr2 = Arrays.asList(2, 6, 8, 9);
        List<Integer> arr3 = Arrays.asList(10, 17, 19);
        List<Integer> arr4 = Arrays.asList(11, 14, 12);

        Node node1 = convertFromList(arr1);
        Node node2 = convertFromList(arr2);
        Node node3 = convertFromList(arr3);
        Node node4 = convertFromList(arr4);

       List<Node> nodes = new ArrayList<>();
       nodes.add(node1);
       nodes.add(node2);
       nodes.add(node3);
       nodes.add(node4);

       Node sortedNode = bruteForce(nodes);
        printElement(sortedNode);
    }
}
