package _04_queue;

public class ArrayDynamicQueue {

    private int[] data;
    private int head;
    private int tail;

    public ArrayDynamicQueue(int capacity) {
        this.data = new int[capacity];
        this.head = 0;
        this.tail = 0;
    }

    public void enqueue(int value) {
        if (tail == data.length) {
            if (head == 0) {
                throw new RuntimeException("queue full");
            }

            for(int i=head; i< tail; i++) {
                data[i-1] = data[i];
            }

            tail = tail - head;
            head = 0;
        }
        data[tail++] = value;
    }

    public int dequeue() {
        if (tail == head) {
            throw new RuntimeException("queue empty");
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
        var queue = new ArrayDynamicQueue(3);
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
