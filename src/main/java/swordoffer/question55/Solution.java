package swordoffer.question55;

import swordoffer.common.ListNode;

public class Solution {
    // 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // fast slow
        // fast == slow
        // fast = 2 * slow
        ListNode fast = pHead, slow = pHead;
        if (fast == null || fast.next == null) {
            return null;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        slow = pHead;
        if (fast != null && fast.next != null) {
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;
    }
}
