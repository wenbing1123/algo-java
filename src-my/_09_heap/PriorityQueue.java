package _09_heap;

import static _00_utils.Utils.swap;

public class PriorityQueue<E extends Comparable<E>> {

    private Object[] data;
    private int count;

    public PriorityQueue(int capacity) {
        this.data = new Object[capacity];
        this.count = 0;
    }

    public void enqueue(E value) {
        if (count >= data.length) {
            return;
        }
        data[count] = value;
        shiftUp(count);
        count++;
    }

    public E dequeue() {
        if (count > 0) {
            E value = (E)data[0];
            swap(data, 0, count-1);
            count--;
            siftDown(0);
            return value;
        }
        return null;
    }

    private int getParent(int i) {
        if (i == 0) {
            return -1;
        }
        return (i-1) / 2;
    }

    private int getLeft(int i) {
        int left = 2 * i + 1;
        return left < count ? left : -1;
    }

    private int getRight(int i) {
        int right = 2 * i + 2;
        return right < count ? right : -1;
    }

    private void shiftUp(int i) {
        int p = getParent(i);
        while (p > -1 && compareTo(data[p], data[i]) > 0) {
            swap(data, i, p);
            i = p;
            p = getParent(i);
        }
    }

    protected void siftDown(int i) {
        int targetI = i;
        while (true) {
            int l = getLeft(i), r = getRight(i);
            if (l>-1 && l<count && compareTo(data[targetI], data[l]) > 0) {
                targetI = l;
            }
            if (r>-1 && r<count && compareTo(data[targetI], data[r]) > 0) {
                targetI = r;
            }
            if (targetI == i) {
                break;
            }
            swap(data, i, targetI);
            i = targetI;
        }
    }

    private int compareTo(Object a, Object b) {
        return ((E)a).compareTo((E)b);
    }

    public static void main(String[] args) {
        var queue = new PriorityQueue<Integer>(10);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(1);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
