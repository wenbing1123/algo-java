//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if ("".equals(s)) {
            return "";
        }

        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], i, i+1, true);
        }
        int maxI=0, maxJ=0;
        for (int i=s.length()-2; i>=0; i--) {
            for (int j=i+1; j<s.length(); j++) {
                if ((j == i+1 || dp[i+1][j-1] == true) && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (j-i > maxJ-maxI) {
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }
        return s.substring(maxI, maxJ+1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
