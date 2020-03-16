//Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list. 
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes in the 
//end should remain as it is. 
//
// 
// 
//
// Example: 
//
// Given this linked list: 1->2->3->4->5 
//
// For k = 2, you should return: 2->1->4->3->5 
//
// For k = 3, you should return: 3->2->1->4->5 
//
// Note: 
//
// 
// Only constant extra memory is allowed. 
// You may not alter the values in the list's nodes, only nodes itself may be ch
//anged. 
// 
// Related Topics Linked List

package leetcode.editor.en;

import leetcode.common.ListNode;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy, end = dummy;
            while (end.next != null) {
                for (int i = 0; i < k; i++) {
                    if (end == null) {
                        break;
                    }
                    end = end.next;
                }
                if (end == null) {
                    break;
                }
                ListNode start = pre.next;
                ListNode next = end.next;
                end.next = null;
                pre.next = reverse(start);
                start.next = next;
                pre = start;
                end = start;
            }
            return dummy.next;
        }

        private ListNode reverse(ListNode node) {
            ListNode current = node, pre = null, next = null;
            while (current != null) {
                next = current.next;
                current.next = pre;
                pre = current;
                current = next;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
