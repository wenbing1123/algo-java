//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new LinkedList<>());
        return res;
    }

    private void backtrack(int[] nums, int curr, LinkedList<Integer> list) {
        res.add(new ArrayList<>(list));
        for(int i=curr; i<nums.length;i++) {
            list.add(nums[i]);
            backtrack(nums, i+1, list);
            list.removeLast();
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
