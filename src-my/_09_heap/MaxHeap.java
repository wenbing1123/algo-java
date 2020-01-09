package _09_heap;

import static _00_utils.Utils.randomNums;

public class MaxHeap extends Heap{

    public MaxHeap(int capacity) {
        super(capacity, true);
    }

    public MaxHeap(int[] data) {
        super(data, true);
    }

    public static void main(String[] args) {
        var heap = new MaxHeap(new int[] {1,2,3,4,5,6,7});
        heap.printAll();
        System.out.println(heap.pop());
        heap.printAll();

        var heap1 = new MaxHeap(10);
        heap1.push(1);
        heap1.push(2);
        heap1.push(3);
        heap1.push(4);
        heap1.push(5);
        heap1.push(6);
        heap1.push(7);
        heap1.printAll();

        var heap2 = new MaxHeap(randomNums());
        heap2.printAll();
        heap2.sort();
        heap2.printAll();
    }

}
