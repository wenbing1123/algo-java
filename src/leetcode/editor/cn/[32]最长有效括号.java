//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int res=0, left=0, right=0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else {
                right++;
            }

            if (left==right) {
                res = Math.max(res, 2*right);
            } else if(right>=left) {
                left=right=0;
            }
        }

        left=right=0;
        for(int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            if (left==right) {
                res = Math.max(res, 2*left);
            } else if(left>=right) {
                left=right=0;
            }
        }

        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
