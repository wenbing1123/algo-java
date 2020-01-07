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
        int res = 0;

        for(int i=0; i<s.length();i++) {
            for(int j=i+2; j<=s.length(); j=j+2) {
                if (isValid(s.substring(i,j))) {
                    res = Math.max(res, j-i);
                }
            }
        }

        return res;
    }

    private boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (!stack.empty()) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.empty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
