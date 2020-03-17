//Given a sorted linked list, delete all nodes that have duplicate numbers, leav
//ing only distinct numbers from the original list. 
//
// Return the linked list sorted as well. 
//
// Example 1: 
//
// 
//Input: 1->2->3->3->4->4->5
//Output: 1->2->5
// 
//
// Example 2: 
//
// 
//Input: 1->1->1->2->3
//Output: 2->3
// 
// Related Topics Linked List

package leetcode.editor.en;

import leetcode.common.ListNode;

public class RemoveDuplicatesFromSortedListIi {

    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode current = head.next;
            while (current != null) {
                if (current.val == head.val) {
                    current = current.next;
                } else {
                    break;
                }
            }
            if (current == head.next) {
                head.next = deleteDuplicates(current);
                return head;
            } else {
                return deleteDuplicates(current);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
