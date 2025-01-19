package org.example.ds.leetcode.hashtables.problem706;

/**
 * Hash Map Design using Array of Nodes
 * Time Complexity - O(N/B) - nodes by buckets
 */
public class HashMapUsingNodeList {

    private class Node {
        int key, val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] nodes; //array of nodes
    private int SIZE = 1000; // holds 1000 bucket index

    public HashMapUsingNodeList() {
        nodes = new Node[SIZE];
    }

    /**
     * Index of bucket for a given node key
     * @param key
     * @return
     */
    private int getIndex(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    /**
     * Find this node by key
     * @param head
     * @param key
     * @return
     */
    private Node find(Node head, int key) {
        Node prev = null;
        while (head != null && head.key != key) {
            prev = head;
            head = head.next;
        }
        return prev;
    }

    /**
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        int index = getIndex(key);
        if (nodes[index] == null) {
            nodes[index] = new Node(key, value);
        }
        Node node = find(nodes[index], value);
        if (node.next == null) {
            node.next = new Node(key, value);
        } else {
            node.next.val = value;
        }

    }

    public int get(int key) {
        int index = getIndex(key);
        if (nodes[index] == null) return -1;
        Node node = find(nodes[index], key);
        if (node.next == null) return -1;
        return node.next.val;
    }

    public void remove(int key) {
        int index = getIndex(key);
        if (nodes[index] == null) return;
        Node node = find(nodes[index], key);
        if (node.next == null) return;
        node.next = node.next.next;

    }
}
