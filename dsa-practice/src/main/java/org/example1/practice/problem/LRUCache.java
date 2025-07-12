package org.example1.practice.problem;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Node> nodeMap;
    int capacity;
    Node head;
    Node tail;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.nodeMap = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
    }


    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAfterHead(Node node) {
        Node currentAfterHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = currentAfterHead;
    }


    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        Node node = nodeMap.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            deleteNode(node);
            insertAfterHead(node);
        } else {
            if (nodeMap.size() == capacity) {
                Node lru = tail.prev;
                nodeMap.remove(lru.key);
                deleteNode(lru);
            }
            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            insertAfterHead(newNode);

        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.put(2, 6);
        lruCache.put(4, 7);
        lruCache.put(8, 11);
        lruCache.put(7, 10);
        lruCache.get(2);
        lruCache.get(8);
        lruCache.put(5, 6);
        lruCache.get(4);
        lruCache.put(5, 11);
    }


}
