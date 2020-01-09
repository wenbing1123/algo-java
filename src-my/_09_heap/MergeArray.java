package _09_heap;

import java.util.Arrays;

public class MergeArray {

    public static void main(String[] args) {
        int[][] a = new int[4][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[] {1,3,6,7,9};
        }

        var queue = new PriorityQueue<Integer>(20);
        for (int i = 0; i < a.length; i++) {
            for(int j=0;j<a[i].length; j++) {
                queue.enqueue(a[i][j]);
            }
        }

        int[] b = new int[20];
        for (int i = 0; i < b.length; i++) {
            b[i] = queue.dequeue();
        }

        System.out.println(Arrays.toString(b));
    }
}
