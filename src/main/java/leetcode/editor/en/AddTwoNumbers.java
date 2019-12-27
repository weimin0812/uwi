//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself. 
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
            ListNode current = ret, node1 = l1, node2 = l2;
            int carry = 0;
            while (carry != 0 || node1 != null || node2 != null) {
                int x = node1 == null ? 0 : node1.val, y = node2 == null ? 0 : node2.val;
                int sum = (x + y + carry) % 10;
                carry = (x + y + carry) / 10;
                current.next = new ListNode(sum);
                current = current.next;
                node1 = node1 == null ? null : node1.next;
                node2 = node2 == null ? null : node2.next;
            }
            return ret.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
