package _05_sort;

import java.util.Arrays;

public class MergeSort {


    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left+right)>>>1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        int i=left,j=mid+1,k=0;
        int[] tmp = new int[right-left+1];
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k] = nums[i];
                k++;
                i++;
            } else {
                tmp[k] = nums[j];
                k++;
                j++;
            }
        }

        while (i<=mid) {
            tmp[k] = nums[i];
            k++;
            i++;
        }

        while (j<=right) {
            tmp[k] = nums[j];
            k++;
            j++;
        }

        for(i=0; i<=right-left;i++) {
            nums[i+left] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,1};
        mergeSort(nums, 0, nums.length-1);
        assert Arrays.equals(new int[]{1,2,3,4}, nums);
    }

}
