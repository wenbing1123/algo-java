package _07_hash;

import java.util.HashMap;

public class LRUCache<K, V> {

    private final static Integer DEFAULT_CAPACITY = 10;

    private Node<K, V> head;
    private Node<K, V> tail;
    private int capacity;
    private int length;
    private HashMap<K, Node<K, V>> table;

    public LRUCache() {
        this(DEFAULT_CAPACITY);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.table = new HashMap<>();
        this.length = 0;
        this.head = this.tail = null;
    }

    static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> prev;
        private Node<K, V> next;

        Node() {
        }

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    public void add(K key, V value) {
        Node<K, V> node = table.get(key);
        if (node == null) {
            node = new Node<>(key, value);
            table.put(key, node);
            addNode(node);
            if (++length > capacity) {
               Node oldNode = popTail();
               table.remove(oldNode.key);
               length--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public V get(K key) {
        Node<K, V> node = table.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public void remove(K key) {
        Node<K, V> node = table.get(key);
        if (node == null) {
            return;
        }
        removeNode(node);
        length--;
        table.remove(node.key);
    }

    private void addNode(Node<K, V> newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    private void removeNode(Node<K, V> node) {
        if (node == head) {
            head = head.next;
            head.prev = null;
        } else if (node == tail){
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private Node<K, V> popTail() {
        Node<K, V> node = tail;
        removeNode(node);
        return node;
    }

    private void printAll() {
        if (head != null) {
            Node<K, V> node = head;
            while (node != null) {
                System.out.print(node.value + ",");
                node = node.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>();
        cache.printAll();
    }
}
