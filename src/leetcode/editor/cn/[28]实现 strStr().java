//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if ("".equals(haystack) && "".equals(needle)) {
            return 0;
        }

        int n = haystack.length(), m = needle.length();
        if (m >= n && !needle.equals(haystack)) {
            return -1;
        }

        int[] s_memo = new int[n - m + 1];
        s_memo[0] = getHashcode(haystack.substring(0, m));
        for (int i=1; i<n-m+1; i++) {
            s_memo[i] = s_memo[i-1] - getHashcode(haystack.substring(i-1, i)) + getHashcode(haystack.substring(i+m-1, i+m));
        }

        int p_memo = getHashcode(needle);

        for (int i = 0; i < s_memo.length; i++) {
            if (s_memo[i] == p_memo) {
                if (haystack.substring(i,i+m).equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }

    private int getHashcode(String s) {
        int res = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            res += c[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
