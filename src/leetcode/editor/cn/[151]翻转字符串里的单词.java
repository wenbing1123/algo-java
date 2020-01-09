//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 进阶： 
//
// 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。 
// Related Topics 字符串



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        String t = s.trim();
        if ("".equals(t)) {
            return "";
        }
        t = reverse(t);
        String[] arr = t.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (!"".equals(arr[i])) {
                builder.append(reverse(arr[i])).append(" ");
            }
        }
        return builder.toString().trim();
    }

    private String reverse(String s) {
        s = s.trim();
        char[] c = s.toCharArray();
        int i=0,j=c.length-1;
        while (i<j) {
            char t = c[i];
            c[i] = c[j];
            c[j] = t;
            i++;
            j--;
        }
        return String.valueOf(c);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
