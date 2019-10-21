package question025;

import common.ListNode;

public class Solution {
    // 递归和迭代
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        ListNode pre = dummy;
        while (current != null) {
            for (int i = 0; i < k; i++) {
                if (current == null) {
                    break;
                }
                current = current.next;
            }
        }

        return dummy.next;
    }



}
