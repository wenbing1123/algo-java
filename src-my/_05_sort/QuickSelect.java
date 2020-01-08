package _05_sort;

public class QuickSelect extends QuickSort {

    public static int quickSelect(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private static int quickSelect(int[] nums, int l, int r, int k) {
        if (l >= r) {
            if (l + 1 == k) {
                return nums[l];
            }
            return 0;
        }
        int p = partition(nums, l, r);
        if (p + 1 == k) {
            return nums[p];
        }

        if (p + 1 > k) {
            return quickSelect(nums, l, p - 1, k);
        }

        return quickSelect(nums, p + 1, r, k);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 3, 3, 3, 3, 3, 5, 6, 7, 9, 10, 11, 8};
        System.out.println(quickSelect(nums, 4));
    }

}
