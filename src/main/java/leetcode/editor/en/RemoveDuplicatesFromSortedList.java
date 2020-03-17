//Given a sorted linked list, delete all duplicates such that each element appea
//r only once. 
//
// Example 1: 
//
// 
//Input: 1->1->2
//Output: 1->2
// 
//
// Example 2: 
//
// 
//Input: 1->1->2->3->3
//Output: 1->2->3
// 
// Related Topics Linked List

package leetcode.editor.en;

import leetcode.common.ListNode;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
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
            while (current != null && current.val == head.val) {
                current = current.next;
            }
            head.next = deleteDuplicates(current);
            return head;
        }
//        public ListNode deleteDuplicates(ListNode head) {
//            ListNode current = head;
//            while (current != null && current.next != null) {
//                if (current.val == current.next.val) {
//                    current.next = current.next.next;
//                } else {
//                    current = current.next;
//                }
//            }
//            return head;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
