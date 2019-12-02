//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int res = 0;
        for (int i=0; i<s.length(); i++) {
            int iMax = 1;
            for(int j = i+1; j<s.length(); j++) {
                String t = s.substring(i, j);
                boolean repeat = false;
                for( int x = 0; x<t.length(); x++) {
                    if (t.charAt(x) == s.charAt(j)) {
                        repeat = true;
                        break;
                    }
                }
                if (!repeat) {
                    iMax ++;
                } else {
                    break;
                }
            }
            res = Math.max(res, iMax);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
