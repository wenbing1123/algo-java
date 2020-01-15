//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> dictT = new HashMap<>();
        for (int i=0; i<t.length();i++) {
            dictT.put(t.charAt(i), dictT.getOrDefault(t.charAt(i), 0)+1);
        }

        int l=0,r=0, formed=0,required = dictT.size();
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        int[] ans = {-1, 0, 0};
        while (r < s.length()) {
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0)+1);
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            while (l <= r && formed == required) {
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                l++;
            }

            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
