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
        int[][] memo = new int[nums.length][nums.length];
        for(int[] l : memo) {
            Arrays.fill(l, -1);
        }
        return maxLIS(nums, -1, 0, memo);
    }

    private int maxLIS(int[] nums, int prev, int curr, int[][] memo) {
        if (curr == nums.length) {
            return 0;
        }

        if (memo[prev+1][curr] >= 0) {
            return memo[prev+1][curr];
        }

        int token = 0;
        if (prev < 0 || nums[curr] > nums[prev]) {
            token = 1 + maxLIS(nums, curr, curr+1, memo);
        }

        int notoken = maxLIS(nums, prev, curr+1, memo);
        int max = Math.max(token, notoken);
        memo[prev+1][curr] = max;
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
