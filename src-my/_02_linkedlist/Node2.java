package _02_linkedlist;

public class Node2 {
    public int data;
    public Node2 prev;
    public Node2 next;

    public Node2(int data, Node2 prev, Node2 next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

}
