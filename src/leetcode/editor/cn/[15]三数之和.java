//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        if (nums[0] <= 0 && nums[nums.length-1] >= 0) {
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i]>0) {
                    break;
                }
                if (i>0 && nums[i] == nums[i-1]) {
                    continue;
                }

                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    int t = nums[i] + nums[j] + nums[k];
                    if (t == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                        while (j < k && nums[j]==nums[j-1]) {
                            j++;
                        }
                        while (j < k && nums[k]==nums[k+1]) {
                            k--;
                        }
                    } else if (t > 0) {
                        k--;
                        while (j < k && nums[k]==nums[k+1]) {
                            k--;
                        }
                    } else {
                        j++;
                        while (j < k && nums[j]==nums[j-1]) {
                            j++;
                        }
                    }
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
