package _01_array;

import java.util.Arrays;

public class MergeSortedArray {

    public static int[] mergeSortedArray(int[] a, int[] b) {
        int[] c = new int[a.length+b.length];
        int i=0, j=0,k=0;
        while (i<a.length && j < b.length){
            if(a[i] <= b[j]) {
               c[k] = a[i];
               i++;
               k++;
            } else {
               c[k] = b[j];
               j++;
               k++;
            }
        }

        while (i < a.length) {
            c[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            c[k] = b[j];
            j++;
            k++;
        }

        return c;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,4,6,8,9};
        int[] b = new int[]{2,3,5,6,8, 10, 12};
        System.out.println(Arrays.toString(mergeSortedArray(a, b)));
    }

}
