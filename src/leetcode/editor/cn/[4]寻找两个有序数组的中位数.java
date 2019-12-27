//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。 
//
// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return median(nums2);
        }

        if (nums2 == null || nums2.length == 0) {
            return median(nums1);
        }

        int[] nums3 = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length || j < nums2.length) {
            if (j >= nums2.length) {
                nums3[k] = nums1[i];
                i++;
            } else if (i >= nums1.length) {
                nums3[k] = nums2[j];
                j++;
            } else {
                if (nums1[i] <= nums2[j]) {
                    nums3[k] = nums1[i];
                    i++;
                } else {
                    nums3[k] = nums2[j];
                    j++;
                }
            }
            k ++;
        }

        return median(nums3);
    }

    private double median(int[] nums) {
        int length = nums.length;
        int l = length % 2;
        if (l == 1) {
            return nums[length / 2];
        } else {
            return (nums[length / 2 - 1] + nums[length / 2]) / 2.0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
