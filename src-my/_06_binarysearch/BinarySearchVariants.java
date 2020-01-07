package _06_binarysearch;

public class BinarySearchVariants {

    public static int binarySearchFirst(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while (left <= right) {
            int mid = (left+right) >> 1;
            if (nums[mid] >= target) {
                if (nums[mid] == target && (mid == 0 || nums[mid] != nums[mid-1])) {
                    return mid;
                }
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static int binarySearchLast(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while (left <= right) {
            int mid = (left+right) >> 1;
            if (nums[mid] <= target) {
                if (nums[mid] == target && (mid == nums.length-1 || nums[mid] != nums[mid+1])) {
                    return mid;
                }
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }

    public static int binarySearchFirstLessThan(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while (left <= right) {
            int mid = (left+right) >> 1;
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid-1] < target) {
                    return mid-1;
                }
                right = mid-1;
            } else if (nums[mid] < target) {
                left = mid+1;
            }
        }
        return -1;
    }

    public static int binarySearchFirstMoreThan(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while (left <= right) {
            int mid = (left+right) >> 1;
            if (nums[mid] > target) {
                right = mid-1;
            } else {
                if (mid == nums.length-1 || nums[mid+1] > target) {
                    return mid == nums.length-1 ? -1 : mid+1;
                }
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,5,5,5,6};
        System.out.println(binarySearchFirst(nums, 5));
        System.out.println(binarySearchLast(nums, 5));
        System.out.println(binarySearchFirstLessThan(nums, 3));
        System.out.println(binarySearchFirstMoreThan(nums, 7));
    }
}
