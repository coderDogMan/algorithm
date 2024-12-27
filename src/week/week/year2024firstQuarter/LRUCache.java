package week.week.year2024firstQuarter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class LRUCache {
    class Node {
        int k, v;
        Node pre, next;
        public Node() {}
        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    int capacity;
    HashMap<Integer, Node> map;
    Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        head.pre = tail;
        tail.pre = head;
        tail.next = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            addHead(node);
            return node.v;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.v = value;
            remove(node);
            addHead(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
            addHead(node);
        }
        if (map.size() > capacity) {
            removeTail();
        }
    }

    private void removeTail() {
        Node node = tail.pre;
        remove(node);
        map.remove(node.k);
    }

    private void addHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next = node;
        node.next.pre = node;
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = null;
        node.pre = null;
    }
}

//
//class Test39 {
//    public static void main(String[] args) {
//        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // 返回  1
//        cache.put(3, 3);    // 该操作会使得密钥 2 作废
//        cache.get(2);       // 返回 -1 (未找到)
//        cache.put(4, 4);    // 该操作会使得密钥 1 作废
//        cache.get(1);       // 返回 -1 (未找到)
//        cache.get(3);       // 返回  3
//        cache.get(4);       // 返回  4
//
//    }
//}
