//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] table = new int[m][n];

        int sum=0;
        for(int i=0; i<m; i++) {
            sum += grid[i][0];
            table[i][0] = sum;
        }
        sum=0;
        for(int i=0; i<n ;i++) {
            sum += grid[0][i];
            table[0][i]=sum;
        }

        for(int i=1; i<m; i++) {
            for (int j=1;j<n;j++) {
                table[i][j] = grid[i][j] + Math.min(table[i-1][j], table[i][j-1]);
            }
        }

        return table[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
