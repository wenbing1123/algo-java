package _05_sort;

import java.util.Arrays;

import static _00_utils.Utils.swap;

public class BaseSort {

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean haveSwap = false;
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                    haveSwap = true;
                }
            }
            if (!haveSwap) {
                break;
            }
        }
    }

    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i], j=i-1;
            while (j>=0 && num <= nums[j]) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = num;
        }
    }

    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i], index = i;
            for(int j=i+1;j<nums.length;j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            swap(nums, i, index);
        }
    }

    public static void main(String[] args) {
        assertBubbleSort();
        assertInsertSort();
        assertSelectSort();
    }

    private static void assertBubbleSort() {
        int[] arr1 = new int[] {1, 1, 1, 1};
        bubbleSort(arr1);
        assert Arrays.equals(new int[] {1, 1, 1, 1}, arr1);

        int[] arr2 = new int[] {4, 1, 2, 3};
        bubbleSort(arr2);
        assert Arrays.equals(new int[] {1, 2, 3, 4}, arr2);

        int[] arr3 = new int[] {1, 2, 3, 4};
        bubbleSort(arr3);
        assert Arrays.equals(new int[] {1, 2, 3, 4}, arr3);

        int[] arr4 = new int[] {4, 3, 1, 2};
        bubbleSort(arr4);
        assert Arrays.equals(new int[] {1, 2, 3, 4}, arr4);
    }

    private static void assertInsertSort() {
        int[] arr1 = new int[] {1, 1, 1, 1};
        insertSort(arr1);
        assert Arrays.equals(new int[] {1, 1, 1, 1}, arr1);

        int[] arr2 = new int[] {4, 1, 2, 3};
        insertSort(arr2);
        assert Arrays.equals(new int[] {1, 2, 3, 4}, arr2);

        int[] arr3 = new int[] {1, 2, 3, 4};
        insertSort(arr3);
        assert Arrays.equals(new int[] {1, 2, 3, 4}, arr3);

        int[] arr4 = new int[] {4, 3, 1, 2};
        insertSort(arr4);
        assert Arrays.equals(new int[] {1, 2, 3, 4}, arr4);
    }

    private static void assertSelectSort() {
        int[] arr1 = new int[] {1, 1, 1, 1};
        selectSort(arr1);
        assert Arrays.equals(new int[] {1, 1, 1, 1}, arr1);

        int[] arr2 = new int[] {4, 1, 2, 3};
        selectSort(arr2);
        assert Arrays.equals(new int[] {1, 2, 3, 4}, arr2);

        int[] arr3 = new int[] {1, 2, 3, 4};
        selectSort(arr3);
        assert Arrays.equals(new int[] {1, 2, 3, 4}, arr3);

        int[] arr4 = new int[] {4, 3, 1, 2};
        selectSort(arr4);
        assert Arrays.equals(new int[] {1, 2, 3, 4}, arr4);
    }

}
