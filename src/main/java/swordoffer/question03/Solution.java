package swordoffer.question03;

import swordoffer.common.ListNode;

import java.util.ArrayList;

public class Solution {
    // 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode == null) {
            return ret;
        }
        ListNode current = listNode;
        while (current != null) {
            ret.add(0, current.val);
            current = current.next;
        }
        return ret;
    }
}
