package _12_divide_and_conquer;

import java.util.Arrays;

public class InversionCountBaseMergeSort {

    private int inversionCount = 0;

    private void mergeCount(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) >>> 1;
        mergeCount(nums, l, mid);
        mergeCount(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int i = l, j = mid + 1, k = 0;
        int[] tmp = new int[r - l + 1];
        while (i <= mid && j <= r) {
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

        while (i <= mid) {
            tmp[k] = nums[i];
            k++;
            i++;
        }

        while (j <= r) {
            tmp[k] = nums[j];
            k++;
            j++;
        }

        for (i = 0; i <= r - l; i++) {
            nums[i + l] = tmp[i];
        }

    }

    public static void main(String[] args) {
        InversionCountBaseMergeSort bean = new InversionCountBaseMergeSort();
        int[] nums = new int[]{5, 0, 4, 2, 3, 1, 3, 3, 3, 6, 8, 7};
        bean.mergeCount(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        System.out.println("inversionCount:" + bean.inversionCount);
    }

}
