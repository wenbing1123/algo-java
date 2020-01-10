//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 深度优先搜索 链表



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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

    private ListNode p;

    public TreeNode sortedListToBST(ListNode head) {
        int size = getSize(head);
        p = head;
        return recur(0, size-1);
    }

    private int getSize(ListNode head) {
        int c = 0;
        while (head != null) {
            c++;
            head = head.next;
        }
        return c;
    }

    private TreeNode recur(int l, int r) {
        if (l > r) return null;
        int mid = (l+r)>>>1;
        TreeNode left = recur(l, mid-1);

        TreeNode node = new TreeNode(p.val);
        node.left = left;

        p = p.next;
        node.right = recur(mid+1, r);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
