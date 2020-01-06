package _04_queue;

import _02_linkedlist.Node;

public class LinkedListQueue {

    private Node head;
    private Node tail;

    public void enqueue(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public int dequeue() {
        if (head == null) {
            throw new RuntimeException("queue empty");
        }

        int value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data+" ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        var queue = new LinkedListQueue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        queue.enqueue(6);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.printAll();
    }

}
