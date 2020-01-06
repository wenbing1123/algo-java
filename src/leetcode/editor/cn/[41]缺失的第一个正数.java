//给定一个未排序的整数数组，找出其中没有出现的最小的正整数。 
//
// 示例 1: 
//
// 输入: [1,2,0]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [3,4,-1,1]
//输出: 2
// 
//
// 示例 3: 
//
// 输入: [7,8,9,11,12]
//输出: 1
// 
//
// 说明: 
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。 
// Related Topics 数组



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {

        boolean hasOne = false;
        for(int i=0; i<nums.length;i++) {
            if (nums[i] == 1) {
                hasOne = true;
                break;
            }
        }
        if(!hasOne) {
            return 1;
        }

        if(nums.length == 1) {
            return 2;
        }

        for(int i=0; i<nums.length;i++) {
            if (nums[i] <= 0 || nums[i]>nums.length) {
                nums[i] = 1;
            }
        }

        for(int i=0; i<nums.length;i++) {
            int a = Math.abs(nums[i]);
            if (a == nums.length) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = -Math.abs(nums[a]);
            }
        }

        for(int i=1; i<nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        if (nums[0] > 0) {
            return nums.length;
        }

        return nums.length + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
