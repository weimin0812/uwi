package question021;

import common.ListNode;

public class Solution {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                current.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l1.val > l2.val ? l2 : l1;
                if (l1.val > l2.val) {
                    l2 = l2.next;
                } else {
                    l1 = l1.next;
                }
            }
            current = current.next;
        }

        return dummy.next;
    }

    // recursion
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }

        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
