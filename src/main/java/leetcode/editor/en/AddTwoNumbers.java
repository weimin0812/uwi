//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Example: 
//
// 
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
// 
// Related Topics Linked List Math

package leetcode.editor.en;

import leetcode.common.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode ret = new ListNode(0);
            ListNode current = ret;
            int carry = 0;
            while (l1 != null || l2 != null || carry != 0) {
                int x = l1 == null ? 0 : l1.val;
                int y = l2 == null ? 0 : l2.val;
                int t = x + y + carry;
                current.next = new ListNode(t % 10);
                carry = t / 10;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
                current = current.next;
            }
            return ret.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
