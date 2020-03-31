//Merge k sorted linked lists and return it as one sorted list. Analyze and desc
//ribe its complexity. 
//
// Example: 
//
// 
//Input:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//Output: 1->1->2->3->4->4->5->6
// 
// Related Topics Linked List Divide and Conquer Heap

package leetcode.editor.en;

import leetcode.common.ListNode;

public class MergeKSortedLists {

    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            int d = 1, l = lists.length;
            while (d < l) {
                for (int i = 0; i < l - d; i = i + 2 * d) {
                    lists[i] = mergeTwoLists(lists[i], lists[i + d]);
                }
                d = d * 2;
            }
            return lists[0];
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode ret = new ListNode(0);
            ListNode current = ret;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    current.next = l1;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    l2 = l2.next;
                }
                current = current.next;
            }
            if (l1 != null) {
                current.next = l1;
            }
            if (l2 != null) {
                current.next = l2;
            }
            return ret.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
