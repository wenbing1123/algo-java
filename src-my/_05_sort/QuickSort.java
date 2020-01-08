package _05_sort;

import java.util.Arrays;

import static _00_utils.Utils.swap;

public class QuickSort {

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int p = partition(nums, left, right);
        quickSort(nums, left, p-1);
        quickSort(nums, p+1, right);
    }

    public static int partition(int[] nums, int l, int r) {
        int pivot = nums[r],i=l;
        for (int j = l; j < r; j++) {
            if (nums[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    swap(nums, i, j);
                    i++;
                }
            }
        }
        swap(nums, i, r);
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,2,1};
        quickSort(nums, 0, nums.length-1);
        assert Arrays.equals(new int[]{1,2,3,4}, nums);

        int[] arr4 = new int[] {4, 3, 1, 2};
        quickSort(arr4, 0, arr4.length-1);
        assert Arrays.equals(new int[] {1, 2, 3, 4}, arr4);
    }

}
