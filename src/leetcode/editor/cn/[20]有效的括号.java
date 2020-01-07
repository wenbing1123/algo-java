//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        }
        if (s.length() == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        stack.push(c[0]);
        for(int i=1;i<c.length;i++) {
            if (isClose(c[i]) && (stack.empty() || !match(stack.pop(), c[i]))) {
                return false;
            }

            if (!isClose(c[i])) {
                stack.push(c[i]);
            }
        }

        if (stack.empty()) {
            return true;
        }
        return false;
    }

    private boolean isClose(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private boolean match(char a, char b) {
        if ((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}')) {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
