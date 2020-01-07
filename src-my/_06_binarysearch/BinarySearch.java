package _06_binarysearch;

public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5};
        System.out.println(binarySearch(nums, 5));
    }

}
