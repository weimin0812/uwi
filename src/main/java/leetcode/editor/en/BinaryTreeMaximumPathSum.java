//Given a non-empty binary tree, find the maximum path sum. 
//
// For this problem, a path is defined as any sequence of nodes from some starti
//ng node to any node in the tree along the parent-child connections. The path mus
//t contain at least one node and does not need to go through the root. 
//
// Example 1: 
//
// 
//Input: [1,2,3]
//
//       1
//      / \
//     2   3
//
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//Output: 42
// 
// Related Topics Tree Depth-first Search

package leetcode.editor.en;

import leetcode.common.TreeNode;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private int ret = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            ret = Integer.MIN_VALUE;
            maxFrom(root);
            return ret;
        }

        private int maxFrom(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int l = Math.max(0, maxFrom(root.left));
            int r = Math.max(0, maxFrom(root.right));
            ret = Math.max(ret, l + r + root.val);
            return root.val + Math.max(l, r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
