package _09_heap;

public class MinHeap extends Heap{

    public MinHeap(int capacity) {
        super(capacity, false);
    }

    public MinHeap(int[] data) {
        super(data, false);
    }

    public static void main(String[] args) {
        var heap = new MinHeap(new int[] {1,2,3,4,5,6,7});
        heap.printAll();

        var heap1 = new MinHeap(10);
        heap1.push(1);
        heap1.push(2);
        heap1.push(3);
        heap1.push(4);
        heap1.push(5);
        heap1.push(6);
        heap1.push(7);
        heap1.printAll();
    }
}
