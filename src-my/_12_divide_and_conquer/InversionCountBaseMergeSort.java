package _12_divide_and_conquer;

import java.util.Arrays;

public class InversionCountBaseMergeSort {

    private int mergeCount(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int mid = (l + r) >>> 1;
        int a = mergeCount(nums, l, mid);
        int b = mergeCount(nums, mid + 1, r);
        int c = merge(nums, l, mid, r);
        return a+b+c;
    }

    private int merge(int[] nums, int l, int mid, int r) {
        int i = l, j = mid + 1, k = 0, count=0;
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
                count += (mid-i+1);
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

        return count;
    }

    public static void main(String[] args) {
        InversionCountBaseMergeSort bean = new InversionCountBaseMergeSort();
        int[] nums = new int[]{1,5,6,2,3,4};
        int inversionCount = bean.mergeCount(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        System.out.println("inversionCount:" + inversionCount);
    }

}
