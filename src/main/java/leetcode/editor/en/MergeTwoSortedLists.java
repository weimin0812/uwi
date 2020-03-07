//Merge two sorted linked lists and return it as a new list. The new list should
// be made by splicing together the nodes of the first two lists. 
//
// Example:
// 
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
// 
// Related Topics Linked List

package leetcode.editor.en;

import leetcode.common.ListNode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }
            ListNode ret = l1.val <= l2.val ? l1 : l2;
            ret.next = mergeTwoLists(l1.val <= l2.val ? l1.next : l1, l1.val <= l2.val ? l2 : l2.next);
            return ret;
        }

//        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//            ListNode ret = new ListNode(0);
//            ListNode current = ret;
//            while (l1 != null && l2 != null) {
//                if (l1.val <= l2.val) {
//                    current.next = l1;
//                    l1 = l1.next;
//                } else {
//                    current.next = l2;
//                    l2 = l2.next;
//                }
//                current = current.next;
//            }
//            if (l1 != null) {
//                current.next = l1;
//            }
//            if (l2 != null) {
//                current.next = l2;
//            }
//            return ret.next;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
