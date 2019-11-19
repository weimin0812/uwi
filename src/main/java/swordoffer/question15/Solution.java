package swordoffer.question15;

import swordoffer.common.ListNode;

public class Solution {
    // 输入一个链表，反转链表后，输出新链表的表头。
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null, next = null, current = head;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
