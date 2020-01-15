//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];
        dp[0] = triangle.get(0).get(0);
        for (int i=1; i<len; i++) {
            List<Integer> l = triangle.get(i);
            for (int j=i; j>=0; j--) {
                if (j==0) {
                    dp[j] = dp[j] + l.get(j);
                } else if (j==i) {
                    dp[j] = dp[j-1] + l.get(j);;
                } else {
                    dp[j] = Math.min(dp[j], dp[j-1]) + l.get(j);
                }
            }
        }
        int min = dp[0];
        for (int i = 1; i < dp.length; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
