package _04_queue;

public class ArrayCycleQueue {

    private int[] data;
    private int head;
    private int tail;

    public ArrayCycleQueue(int capacity) {
        this.data = new int[capacity+1];
        this.head = 0;
        this.tail = 0;
    }

    public void enqueue(int value) {
        if ((tail + 1) % data.length == head) {
            throw new RuntimeException("queue overflow");
        }
        data[tail] = value;
        tail = (tail+1) % data.length;
    }

    public int dequeue() {
        if (head == tail) {
            throw new RuntimeException("queue blank");
        }

        int value = data[head];
        head = (head+1) % data.length;
        return value;
    }

    public void printAll() {
        if (0 == data.length) return;
        for (int i = head; i % data.length != tail; i = (i + 1) % data.length) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        var queue = new ArrayCycleQueue(3);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        queue.enqueue(6);

        queue.printAll();
    }
}
