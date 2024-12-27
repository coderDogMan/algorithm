package other.mid;

import java.util.HashMap;

class LRUCache {
    class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;
        public Node() {};
        public Node(int key, int value) {this.key = key; this.value = value;}
    }

    private Node head, tail;
    private int capacity;
    private int size;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            addHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            addHead(newNode);
            map.put(key, newNode);
            if (map.size() > capacity) {
                Node removeNode = removeTail();
                map.remove(removeNode.key);
            }
        }

    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
    public void moveToHead(Node node) {
        remove(node);
        addHead(node);
    }

    public void addHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }

    public Node removeTail() {
        Node node = tail.prev;
        remove(node);
        return node;
    }
}

