package _05_sort;

import java.util.Arrays;

import static _00_utils.Utils.swap;

public class ThirdSliceQuickSort {

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int p = partition(nums, left, right);
        quickSort(nums, left, p-1);
        quickSort(nums, p+1, right);
    }

    public static int partition(int[] nums, int l, int r) {
        int pivot = nums[r],i=l,j=r-1,k=l;
        while (k<=j) {
            if (nums[k] < pivot) {
                swap(nums, i, k);
                i++;
                k++;
            } else if (nums[k] > pivot){
                swap(nums, k, j);
                j--;
            } else {
                k++;
            }
        }
        swap(nums, k, r);
        return k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,3,2,1};
        quickSort(nums, 0, nums.length-1);
        assert Arrays.equals(new int[]{1,2,2,3,3,4}, nums);

        int[] arr4 = new int[] {4, 3, 1, 2};
        quickSort(arr4, 0, arr4.length-1);
        assert Arrays.equals(new int[] {1, 2, 3, 4}, arr4);
    }

}
