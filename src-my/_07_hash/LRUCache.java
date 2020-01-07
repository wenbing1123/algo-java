package _07_hash;

import java.util.HashMap;

public class LRUCache<K, V> {

    private final static Integer DEFAULT_CAPACITY = 10;

    private Node<K, V> head;
    private Node<K, V> tail;
    private int capacity;
    private int length;
    private HashMap<K, Node<K, V>> table;

    public LRUCache(int capacity) {

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

    public static void main(String[] args) {

    }
}
