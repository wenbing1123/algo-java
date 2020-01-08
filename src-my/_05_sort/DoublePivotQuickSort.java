package _05_sort;

import java.util.Arrays;

public class DoublePivotQuickSort {

    private static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int[] p = partition(nums, left, right);
        quickSort(nums, left, p[0]-1);
        quickSort(nums, p[0]+1, p[1]-1);
        quickSort(nums, p[1]+1, right);
    }

    public static int[] partition(int[] nums, int l, int r) {
        if (nums[l] > nums[r]) {
            swap(nums, l, r);
        }
        int pivot1=nums[l], pivot2=nums[r],i=l,j=r,k=i+1;
        while (k<j) {
            if (nums[k] < pivot1) {
                swap(nums, ++i, k);
                if (i==k) {
                    k++;
                }
            } else if (nums[k] > pivot2) {
                swap(nums, k, --j);
            } else {
                k++;
            }
        }

        swap(nums, l, i);
        swap(nums, k, r);

        return new int[]{i, k};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,2,1};
        quickSort(nums, 0, nums.length-1);
        assert Arrays.equals(new int[]{1,2,2,3,4}, nums);

        int[] arr3 = new int[] {8, 2, 3, 5, 6, 7, 9, 10, 11, 4};
        quickSort(arr3, 0, arr3.length-1);
        assert Arrays.equals(new int[] {2, 3, 4,5,6,7,8,9,10,11}, arr3);

        int[] arr4 = new int[] {4, 3, 1, 2};
        quickSort(arr4, 0, arr4.length-1);
        assert Arrays.equals(new int[] {1, 2, 3, 4}, arr4);
    }

}
