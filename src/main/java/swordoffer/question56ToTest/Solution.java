package swordoffer.question56ToTest;

import swordoffer.common.ListNode;

public class Solution {
    // 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    // 递归 use your fucking brain
    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        if (pHead.val == pHead.next.val) {
            ListNode current = pHead;
            while (current != null && current.val == pHead.val) {
                current = current.next;
            }
            return deleteDuplication1(current);
        }

        pHead.next = deleteDuplication1(pHead.next);
        return pHead;
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode current = pHead, ret = dummy;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                ListNode n = current;
                while (current != null && n.val == current.val) {
                    current = current.next;
                }
                if (current == null) {
                    break;
                }
                ret.next = current;
                ret = ret.next;
                current = current.next;
            } else {
                ret.next = current;
                ret = ret.next;
                current = current.next;
            }
        }

        return ret.next;

    }


}
