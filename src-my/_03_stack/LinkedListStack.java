package _03_stack;

import _02_linkedlist.Node;

public class LinkedListStack {

    private Node top;

    public void push(int value) {
        Node newNode = new Node(value, null);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        if (top == null) {
            return -1;
        }

        int data = top.data;
        top = top.next;
        return data;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        var stack = new LinkedListStack();
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.push(9);
        stack.push(6);

        stack.printAll();

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
