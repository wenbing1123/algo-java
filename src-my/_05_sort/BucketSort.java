package _05_sort;

import java.util.Arrays;

import static _05_sort.QuickSort.quickSort;

public class BucketSort {

    public static void bucketSort(int[] nums, int bucketSize) {
        if (nums.length < 1) {
            return;
        }

        int min=nums[0],max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int bucketCount = (max-min)/bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indexArr = new int[bucketCount];

        for (int i = 0; i < nums.length; i++) {
            int bucketIndex = (nums[i]-min)/bucketSize;
            if (indexArr[bucketIndex] == buckets[bucketIndex].length) {
                ensureCapacity(buckets, bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = nums[i];
        }

        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            int[] n = buckets[i];
            if(n.length<1) {
                continue;
            }
            quickSort(n, 0, indexArr[i]-1);
            for(int j=0; j< indexArr[i]; j++) {
                nums[k++] = buckets[i][j];
            }
        }

    }

    private static void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int j = 0; j < tempArr.length; j++) {
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,2,1};
        bucketSort(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

}
