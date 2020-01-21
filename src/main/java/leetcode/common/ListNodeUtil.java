package leetcode.common;

public class ListNodeUtil {
    public static ListNode convertToListNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode[] nodes = new ListNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new ListNode(nums[i]);
            if (i != 0) {
                nodes[i - 1].next = nodes[i];
            }
        }
        return nodes[0];
    }
}
