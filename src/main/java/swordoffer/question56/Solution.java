package swordoffer.question56;

import swordoffer.common.ListNode;

public class Solution {
    // 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    // 递归 use your fucking brain
    // public ListNode deleteDuplication(ListNode pHead) {
    //     if (pHead == null || pHead.next == null) {
    //         return pHead;
    //     }
    //
    //     if (pHead.val == pHead.next.val) {
    //         ListNode current = pHead;
    //         while (current != null && current.val == pHead.val) {
    //             current = current.next;
    //         }
    //         return deleteDuplication(current);
    //     }
    //
    //     pHead.next = deleteDuplication(pHead.next);
    //     return pHead;
    // }

    // 用例:
    // {1,2,3,3,4,4,5}
    //
    // 对应输出应该为:
    //
    // {1,2,5}
    //
    // 你的输出为:
    //
    // {1,2,4,4,5}
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 2, 3, 3, 4, 4, 5, 6, 7, 8};
        ListNode head = new ListNode(array[0]);
        ListNode current = head;
        for (int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }
        ListNode listNode = solution.deleteDuplication(head);
        int i = 0;
    }

    // 非递归
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode current = pHead, ret = dummy;
        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                int t = current.val;
                while (current != null && current.val == t) {
                    current = current.next;
                }
                ret.next = current;
            } else {
                ret = ret.next;
                current = current.next;
            }
        }

        return dummy.next;
    }


}
