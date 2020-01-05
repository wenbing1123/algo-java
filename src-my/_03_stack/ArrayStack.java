package _03_stack;

public class ArrayStack {

    private int[] data;
    private int top;

    public ArrayStack(int capacity) {
        this.data = new int[capacity];
        this.top = -1;
    }

    public void push(int value) {
        if (top == data.length-1) {
            throw new RuntimeException("stack overflow");
        }

        this.data[++top] = value;
    }

    public int pop() {
        if (top == -1) {
            throw new RuntimeException("stack no data");
        }

        return this.data[top--];
    }

    public void print() {
        for(int i=0; i<=top; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        var stack = new ArrayStack(5);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.push(9);
        stack.push(6);

        stack.print();

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
