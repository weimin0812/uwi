package ebay;

import leetcode.common.ListNode;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(11);
        ListNode current = node;
        for (int i = 10; i >= 0; i--) {
            current.next = new ListNode(i);
            current = current.next;
        }
        ListNode sort = solution.sort(node);
        while (sort != null) {
            System.out.println(sort.val);
            sort = sort.next;
        }
    }

    public ListNode sort(ListNode root) {
        return mergeSort(root);
    }

    private ListNode mergeSort(ListNode root) {
        // null校验啊
        if (root == null || root.next == null) {
            return root;
        }
        ListNode fast = root, slow = root, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        pre.next = null;
        ListNode l1 = mergeSort(root);
        ListNode l2 = mergeSort(slow);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode current = ret;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            } else {
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return ret.next;
    }


}
