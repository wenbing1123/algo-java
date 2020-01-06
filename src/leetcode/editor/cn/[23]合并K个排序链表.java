//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }

        return merge(lists, 0, lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left >= right-1) {
            return merge(lists[left], lists[right]);
        }

        int mid = (left + right) >> 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid+1, right);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode s = new ListNode(-1);
        ListNode l3 = s;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l3.next = l1;
                l3 = l3.next;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l3 = l3.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            l3.next = l1;
            l3 = l3.next;
        }

        if (l2 != null) {
            l3.next = l2;
            l3 = l3.next;
        }

        return s.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
