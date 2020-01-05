package _02_linkedlist;

public class CycleLinkedList {

    private Node head;

    public CycleLinkedList() {
        head = new Node(-1, null); //哨兵节点
        head.next = head;
    }

    public static void main(String[] args) {

    }

}
