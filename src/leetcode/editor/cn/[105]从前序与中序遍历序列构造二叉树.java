//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组



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

    private int[] preorder;
    private int i;
    private HashMap<Integer,Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.i = 0;
        this.inorderMap = buildMap(inorder);
        return recur(inorder, 0, inorder.length-1);
    }

    private TreeNode recur(int[] inorder, int l, int r) {
        if (l > r) return null;
        int s = inorderMap.get(preorder[i]);
        TreeNode root = new TreeNode(preorder[i]);
        i++;
        root.left = recur(inorder, l, s-1);
        root.right = recur(inorder, s+1, r);
        return root;
    }

    private HashMap<Integer, Integer> buildMap(int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return map;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
