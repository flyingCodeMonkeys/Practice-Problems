package LRUCache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> nodeMap;
    int cacheCapacity;

    public LRUCache(int capacity) {
        nodeMap = new HashMap(capacity);
        this.cacheCapacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int res = -1;
        Node node = nodeMap.get(key);
        if(node != null) {
            remove(node);
            add(node);
            res = node.val;
        }
        return res;
    }

    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if(node != null) {
            remove(node);
            node.val = value;
            add(node);
        }
        else {
            if(nodeMap.size() == cacheCapacity){
                nodeMap.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            nodeMap.put(key, newNode);
            add(newNode);
        }
    }

    //Add to end of list
    public void add(Node node) {
        Node headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        head.next = node;
        node.prev = head;
    }

    //Remove from list
    public void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        next.prev = prev;
        prev.next = next;
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }
}
