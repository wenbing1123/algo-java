package _05_sort;

import java.util.Arrays;

public class RadixSort {

    public static void radixSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        for (int exp = 1; max / exp > 0; exp = exp * 10) {
            countingSort(nums, exp);
        }

    }

    private static void countingSort(int[] nums, int exp) {
        // 计算每个值（0-9）的个数
        int[] c = new int[10];
        for (int i = 0; i < nums.length; i++) {
            c[(nums[i] / exp) % 10]++;
        }

        // 计算排序后的位置
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        // 存放数据
        int[] tmp = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            tmp[c[(nums[i] / exp) % 10]-1] = nums[i];
            c[(nums[i] / exp) % 10]--;
        }

        // 复制回原数组
        for (int i = 0; i < tmp.length; i++) {
            nums[i] = tmp[i];
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 11, 8, 22, 54, 23, 21, 22, 45};
        radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
