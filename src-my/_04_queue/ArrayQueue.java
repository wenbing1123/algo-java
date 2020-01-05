package _04_queue;

public class ArrayQueue {

    private int[] data;
    private int head;
    private int tail;

    public ArrayQueue(int capacity) {
        this.data = new int[capacity];
        this.head = 0;
        this.tail = 0;
    }

    public void enqueue(int value) {
        if (tail == data.length) {
            throw new RuntimeException("queue overflow");
        }

        data[tail++] = value;
    }

    public int dequeue() {
        if (head == tail) {
            return -1;
        }

        return data[head++];
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        var queue = new ArrayQueue(5);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        queue.printAll();

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
