//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
//
// Example: 
//
// 
//Input:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//Output: 1->1->2->3->4->4->5->6
// 
// Related Topics Linked List Divide and Conquer Heap
package leetcode.editor.en;

import leetcode.common.ListNode;
import leetcode.common.ListNodeUtil;

import java.util.Arrays;

public class MergeKSortedLists {

    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        ListNode[] nodes = new ListNode[]{
                ListNodeUtil.convertToListNode(new int[]{1, 4, 5}),
                ListNodeUtil.convertToListNode(new int[]{1, 3, 4}),
                ListNodeUtil.convertToListNode(new int[]{2, 6})
        };
        ListNodeUtil.printListNode(solution.mergeKLists(nodes));
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            int d = 1;
            while (d < lists.length) {
                for (int i = 0; i < lists.length - d; i += 2 * d) {
                    lists[i] = mergeTwoList(lists[i], lists[i + d]);
                }
                d = d * 2;
            }
            return lists[0];
        }

        private ListNode mergeTwoList(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }
            ListNode ret = l1.val <= l2.val ? l1 : l2;
            ret.next = mergeTwoList(l1.val <= l2.val ? l1.next : l1, l1.val <= l2.val ? l2 : l2.next);
            return ret;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
