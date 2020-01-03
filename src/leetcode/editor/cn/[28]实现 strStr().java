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

        int[] bc = new int[256];
        generateBC(needle, bc);

        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(needle, suffix, prefix);

        int i = 0;
        while (i <= n-m) {
            int j;
            for(j = m-1; j >= 0; j--) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j < 0) {
                return i;
            }

            int x = j - bc[haystack.charAt(i+j)];
            int y = 0;
            if (j < m-1) {
                int k = m-1-j;
                if(suffix[k] != -1) {
                    y = j - suffix[k] +1;
                } else {
                    boolean f = true;
                    for (int r=j+2;r<m-1;r++) {
                        if (prefix[r] == true) {
                            y = r;
                            f = false;
                            break;
                        }
                    }
                    if(f) {
                        y = m;
                    }
                }
            }

            i = i + Math.max(x, y);
        }

        return -1;
    }

    private void generateBC(String p, int[] bc) {
        for(int i=0;i<bc.length;i++) {
            bc[i] = -1;
        }

        for(int i=0;i<p.length();i++) {
            bc[p.charAt(i)] = i;
        }
    }

    private void generateGS(String p, int[] suffix, boolean[] prefix) {
        for(int i=0;i<suffix.length;i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }

        char[] c = p.toCharArray();
        for(int i=0;i<c.length-1; i++) {
            int j=i;
            int k=0;
            while (j>0 && c[j] == c[c.length-1-k]) {
                j--;
                k++;
                suffix[k] = j+1;
            }
            if(j == -1) {
                prefix[k] = true;
            }
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
