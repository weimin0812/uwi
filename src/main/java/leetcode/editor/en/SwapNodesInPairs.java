//Given a linked list, swap every two adjacent nodes and return its head. 
//
// You may not modify the values in the list's nodes, only nodes itself may be changed. 
//
// 
//
// Example: 
//
// 
//Given 1->2->3->4, you should return the list as 2->1->4->3.
// 
// Related Topics Linked List
package leetcode.editor.en;

import leetcode.common.ListNode;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
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

        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode current = dummy;
            while (current.next != null && current.next.next != null) {
                ListNode first = current.next, second = current.next.next;
                first.next = second.next;
                second.next = first;
                current.next = second;
                current = current.next.next;
            }
            return dummy.next;
        }


//        public ListNode swapPairs(ListNode head) {
//            if (head == null || head.next == null) {
//                return head;
//            }
//            ListNode first = head, second = head.next;
//            first.next = swapPairs(second.next);
//            second.next = first;
//            return second;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
