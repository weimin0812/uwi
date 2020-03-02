package ebay;

import leetcode.common.TreeNode;

public class Solution3 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.right = new TreeNode(3);
        Solution3 solution3 = new Solution3();
        int depth = solution3.getDepth(node);
        System.out.println(depth);
    }
    public int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        // 左子树或者右字数为空的时候，应该返回左右子树大的+1
        if (left == 0 || right == 0) {
            return Math.max(left, right) + 1;
        }
        return Math.min(left, right) + 1;
    }
}
