//Given a singly linked list, determine if it is a palindrome. 
//
// Example 1: 
//
// 
//Input: 1->2
//Output: false 
//
// Example 2: 
//
// 
//Input: 1->2->2->1
//Output: true 
//
// Follow up: 
//Could you do it in O(n) time and O(1) space? 
// Related Topics Linked List Two Pointers

package leetcode.editor.en;

import leetcode.common.ListNode;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
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
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            if (fast != null) {
                slow = slow.next;
            }
            slow = reverse(slow);
            fast = head;
            while (slow != null) {
                if (fast.val != slow.val) {
                    return false;
                }
                fast = fast.next;
                slow = slow.next;
            }
            return true;
        }

        private ListNode reverse(ListNode node) {
            ListNode pre = null, current = node, next = null;
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
