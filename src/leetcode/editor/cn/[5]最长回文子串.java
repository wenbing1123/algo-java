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

        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i, k = i, len = 1;
            while (j - 1 >= 0 && k + 1 <= s.length() - 1 && s.charAt(j - 1) == s.charAt(k + 1)) {
                j--;
                k++;
            }
            if (k - j > right - left) {
                left = j;
                right = k;
            }

            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                j = i;
                k = i + 1;
                while (j - 1 >= 0 && k + 1 <= s.length() - 1 && s.charAt(j - 1) == s.charAt(k + 1)) {
                    len++;
                    j--;
                    k++;
                }
            }
            if (k - j > right - left) {
                left = j;
                right = k;
            }
        }
        return s.substring(left, right + 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
