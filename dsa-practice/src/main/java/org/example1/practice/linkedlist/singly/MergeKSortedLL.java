package org.example1.practice.linkedlist.singly;

import java.util.*;

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

    public static Node convertFromList(List<Integer> list) {
        Node head = new Node(list.get(0));
        Node temp = head;
        for (int i = 1; i < list.size(); i++) {
            temp.next = new Node(list.get(i));
            temp = temp.next;
        }
        return head;
    }

    public static Node betterSolution(List<Node> nodes) {
        Node head = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            head = mergeTwoNode(head, nodes.get(i));
        }
        return head;
    }

    public static Node mergeTwoNode(Node node1, Node node2) {

        Node dNode = new Node(-1);
        Node temp = dNode;
        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                temp.next = node1;
                temp = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                temp = node2;
                node2 = node2.next;
            }
        }
        if (node1 != null) {
            temp.next = node1;
        } else {
            temp.next = node2;
        }
        return dNode.next;
    }


    private static Node optimal(List<Node> nodes) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.data));
        for (Node node : nodes) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while (!minHeap.isEmpty()) {
            Node smallestNode = minHeap.poll();
            temp.next = smallestNode;
            temp = temp.next;
            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }
        return dummyNode.next;

    }


    public static void main(String[] args) {
        List<Integer> arr1 = Arrays.asList(1, 3, 4, 5, 7);
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

        // Node sortedNode = bruteForce(nodes);
        // printElement(sortedNode);
        System.out.println("Better Solution ==");
        // printElement(betterSolution(nodes));
        printElement(optimal(nodes));

    }
}
