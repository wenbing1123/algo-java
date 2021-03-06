package _00_utils;

import java.util.Random;

public class Utils {

    public static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void swap(Object[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        Object tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static int[] randomNums() {
        return randomNums(6, 10);
    }

    public static int[] randomNums(int count) {
        return randomNums(count, 10);
    }

    public static int[] randomNums(int count, int bound) {
        int[] nums = new int[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            nums[i] = random.nextInt(bound);
        }
        return nums;
    }

}
