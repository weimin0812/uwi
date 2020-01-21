//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists. 
//
// Example:
// 
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
// 
// Related Topics Linked List
package leetcode.editor.en;

import leetcode.common.ListNode;
import leetcode.common.ListNodeUtil;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode l1 = ListNodeUtil.convertToListNode(new int[]{1, 2, 4});
        ListNode l2 = ListNodeUtil.convertToListNode(new int[]{1, 3, 4});
        ListNode ret = solution.mergeTwoLists(l1, l2);
        int i = 0;
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
            ListNode ret = new ListNode(0);
            ListNode current = ret;
            while (l1 != null || l2 != null) {
                int x = l1 == null ? Integer.MAX_VALUE : l1.val;
                int y = l2 == null ? Integer.MAX_VALUE : l2.val;
                current.next = x <= y ? l1 : l2;
                current = current.next;
                l1 = x <= y ? l1.next : l1;
                l2 = x <= y ? l2 : l2.next;
            }
            return ret.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
