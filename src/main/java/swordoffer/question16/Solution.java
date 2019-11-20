package swordoffer.question16;

import swordoffer.common.ListNode;

public class Solution {
    public ListNode Merge1(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy, node1 = list1, node2 = list2;
        while (node1 != null || node2 != null) {
            if (node1 != null && node2 != null) {
                if (node1.val <= node2.val) {
                    current.next = node1;
                    current = current.next;
                    node1 = node1.next;
                } else {
                    current.next = node2;
                    current = current.next;
                    node2 = node2.next;
                }
            } else if (node1 != null) {
                current.next = node1;
                current = current.next;
                node1 = node1.next;
            } else {
                current.next = node2;
                current = current.next;
                node2 = node2.next;
            }
        }

        return dummy.next;
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode ret = list1.val <= list2.val ? list1 : list2;
        ret.next = Merge(list1.val <= list2.val ? list1.next : list1, list1.val <= list2.val ? list2 : list2.next);
        return ret;
    }
}
