//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int n;
    private int k;
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < k) return res;
        this.n = n;
        this.k = k;

        LinkedList<Integer> list = new LinkedList<>();
        backtrack(1, list);
        return res;
    }

    private void backtrack(int curr, LinkedList<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i=curr; i<=n; i++) {
            list.add(i);
            backtrack(i+1, list);
            list.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
