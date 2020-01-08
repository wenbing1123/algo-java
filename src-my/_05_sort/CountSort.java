package _05_sort;

import java.util.Arrays;

import static _05_sort.QuickSort.quickSort;

public class CountSort {

    public static void countSort(int[] nums) {
        if (nums.length < 1) {
            return;
        }

        int min=nums[0],max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int bucketCount = max-min+1;
        int[] buckets = new int[bucketCount];

        for (int i = 0; i < nums.length; i++) {
            int bucketIndex = nums[i]-min;
            buckets[bucketIndex]++;
        }

        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            while (buckets[i] > 0) {
                nums[k++] = i+1;
                buckets[i]--;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,2,1};
        countSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
