package _01_array;

public class Array {

    private int[] data;
    private int capacity;
    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    public boolean insert(int index, int value) {
        if (count == capacity) {
            System.out.println("no position");
            return false;
        }

        if (index < 0 || index > count) {
            System.out.println("position invalid");
            return false;
        }

        for (int i = count - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        count++;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }
        for (int i = index; i < count; i++) {
            data[i] = data[i + 1];
        }
        count--;
        return true;
    }

    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }

        return data[index];
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.printAll();
    }
}
