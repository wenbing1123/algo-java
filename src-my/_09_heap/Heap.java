package _09_heap;

import static _00_utils.Utils.swap;

public abstract class Heap {

    public int[] data;
    public int count;
    protected boolean max;

    protected Heap(int capacity, boolean max) {
        this.data = new int[capacity];
        this.count = 0;
        this.max = max;
    }

    protected Heap(int[] data, boolean max) {
        this.data = data;
        this.count = data.length;
        this.max = max;
        heapify();
    }

    protected int getParent(int i) {
        if (i == 0) {
            return -1;
        }
        return (i-1) / 2;
    }

    protected int getLeft(int i) {
        int left = 2 * i + 1;
        return left < count ? left : -1;
    }

    protected int getRight(int i) {
        int right = 2 * i + 2;
        return right < count ? right : -1;
    }

    protected void siftUp(int i) {
        int p = getParent(i);
        while (p > -1 && ((max && data[p] < data[i]) || (!max && data[p] > data[i]))) {
            swap(data, i, p);
            i = p;
            p = getParent(i);
        }
    }

    protected void siftDown(int i) {
        siftDown(i, count);
    }

    protected void siftDown(int i, int k) {
        int targetI = i;
        while (true) {
            int l = getLeft(i), r = getRight(i);
            if (l>-1 && l<k && ((max && data[targetI] < data[l]) || (!max && data[targetI] > data[l]))) {
                targetI = l;
            }
            if (r>-1 && r<k && ((max && data[targetI] < data[r]) || (!max && data[targetI] > data[r]))) {
                targetI = r;
            }
            if (targetI == i) {
                break;
            }
            swap(data, i, targetI);
            i = targetI;
        }
    }

    public void heapify() {
        int i = count/2 - 1;
        for (; i>=0; i--) {
            siftDown(i);
        }
    }

    public void push(int value) {
        if (count >= data.length) {
            return;
        }
        data[count] = value;
        siftUp(count);
        count++;
    }

    public void sort() {
        if (count == 0) {
            return;
        }

        for(int i=count-1; i>=0; i--) {
            swap(data, 0, i);
            siftDown(0, i);
        }
    }

    public int pop() {
        if (count > 0) {
            int value = data[0];
            swap(data, 0, count-1);
            count--;
            siftDown(0);
            return value;
        }
        return -1;
    }

    public void printAll() {
        System.out.println("--------------------------------------");
        for (int i = 0; i < count; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
        System.out.println("--------------------------------------");
    }
}
