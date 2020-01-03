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
        if ("".equals(needle)) {
            return 0;
        }

        int n = haystack.length(), m = needle.length();
        if (m >= n && !needle.equals(haystack)) {
            return -1;
        }

        int[] next = new int[m];
        generateNext(needle, next);

        int i = 0;
        while (i <= n-m) {
            int j;
            for(j = 0; j < m; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j >= m) {
                return i;
            }

            if (j==0) {
                i++;
            } else {
                i = i + (j - 1 - next[j-1]);
            }

        }

        return -1;
    }

    private void generateNext(String p, int[] next) {
        next[0] = -1;
        int k = -1;
        char[] c = p.toCharArray();
        for(int i=1;i<c.length;i++) {
            while (k != -1 && c[k+1] != c[i]) {
                k = next[k];
            }
            if (c[k+1] == c[i]) {
                k++;
            }
            next[i] = k;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
