//Given a linked list, remove the n-th node from the end of list and return its 
//head. 
//
// Example: 
//
// 
//Given linked list: 1->2->3->4->5, and n = 2.
//
//After removing the second node from the end, the linked list becomes 1->2->3->
//5.
// 
//
// Note: 
//
// Given n will always be valid. 
//
// Follow up: 
//
// Could you do this in one pass? 
// Related Topics Linked List Two Pointers

package leetcode.editor.en;

import leetcode.common.ListNode;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode ret = new ListNode(0);
            ret.next = head;
            ListNode fast = ret, slow = ret;
            for (int i = 0; i <= n; i++) {
                if (fast == null) {
                    return null;
                }
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return ret.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
