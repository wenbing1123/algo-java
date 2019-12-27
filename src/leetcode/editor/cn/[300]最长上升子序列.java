//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        return maxLIS(nums, Integer.MIN_VALUE, 0);
    }

    private int maxLIS(int[] nums, int prev, int curr) {
        if (curr == nums.length) {
            return 0;
        }

        int token = 0;
        if (nums[curr] > prev) {
            token = 1 + maxLIS(nums, nums[curr], curr+1);
        }

        int notoken = maxLIS(nums, prev, curr+1);
        return Math.max(token, notoken);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
