//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s1.push(root);
        s2.push(sum - root.val);
        int currNum;
        while (!s1.empty()) {
            TreeNode p = s1.pop();
            currNum = s2.pop();
            if (p.left==null && p.right==null && currNum==0) return true;

            if (p.right != null) {
                s1.push(p.right);
                s2.push(currNum-p.right.val);
            }

            if (p.left != null) {
                s1.push(p.left);
                s2.push(currNum-p.left.val);
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
