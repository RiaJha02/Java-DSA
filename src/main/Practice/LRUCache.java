package src.main.Practice;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key, value;
    Node left, right;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class LRUCache {

    private final int mapCapacity;
    private Map<Integer, Node> lru;

    private Node head, tail;

    public LRUCache(int mapCapacity) {
        this.mapCapacity = mapCapacity;
        this.lru = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.right = tail;
        tail.left = head;
    }

    public int getKey(int key) {
        if(!lru.containsKey(key)) {
            return -1;
        }
        Node node = lru.get(key);
        updateHead(node);
        return node.value;
    }

    public void putKey(int key, int value) {
        if (lru.containsKey(key)) {
            Node existingNode = lru.get(key);
            existingNode.value = value;
            updateHead(existingNode);
            lru.put(key, existingNode);
        }
        else {
            if (mapCapacity <= lru.size()) {
                deleteLRUNode();
            }
            Node newNode = new Node(key, value);
            addToHead(newNode);
            lru.put(key, newNode);

        }
    }

    private void updateHead(Node node) {
        deleteNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        node.right = head.right;
        node.left = head;
        head.right.left = node;
        head.right = node;
    }

    private void deleteNode(Node node) {
        node.left.right = node.right;
        node.right.left = node.left;
    }

    private void deleteLRUNode() {
        if (tail.left == head) return;
        Node lastNode = tail.left;
        deleteNode(lastNode);
        lru.remove(lastNode.key);
    }
}