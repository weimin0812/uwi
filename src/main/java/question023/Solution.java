package question023;

import common.ListNode;

public class Solution {
    // 复杂度太高
    // todo 复杂度
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode ret = null;
        for (int i = 0; i < lists.length; i++) {
            ret = merge2Lists(ret, lists[i]);
        }

        return ret;
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        if (l1.val <= l2.val) {
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        }

        l2.next = merge2Lists(l1, l2.next);
        return l2;
    }
}
