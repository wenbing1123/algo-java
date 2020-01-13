//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        Queue<Integer> neighbors = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i][j];
                if (c == '1') {
                    res++;
                    grid[i][j] = '0';
                    neighbors.add(i*n+j);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.poll();
                        int row = id / n;
                        int col = id % n;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * n + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < m && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * n + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * n + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < n && grid[row][col + 1] == '1') {
                            neighbors.add(row * n + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
