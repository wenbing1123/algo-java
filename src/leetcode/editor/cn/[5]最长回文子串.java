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
        String res = s.substring(0, 1);
        for (int i=0; i<s.length()-1; i++) {
            for(int j=i+1; j < s.length(); j++) {
                String sub = s.substring(i, j+1);
                if(isPalindrome(sub) && sub.length() > res.length()) {
                    res = sub;
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
