package _09_heap;

import java.util.Arrays;

import static _00_utils.Utils.randomNums;

public class TopK {

    public static void main(String[] args) {
        int[] nums = randomNums(10, 100);
        System.out.println(Arrays.toString(nums));
        int k = 5;
        var heap = new MinHeap(k);
        for (int i = 0; i < nums.length; i++) {
            if (i>=5) {
                heap.pop();
            }
            heap.push(nums[i]);
        }
        heap.printAll();
    }
}
