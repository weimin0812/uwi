//
//Given a binary tree, you need to compute the length of the diameter of the tre
//e. The diameter of a binary tree is the length of the longest path between any t
//wo nodes in a tree. This path may or may not pass through the root.
// 
//
// 
//Example: 
//Given a binary tree 
// 
//          1
//         / \
//        2   3
//       / \     
//      4   5    
// 
// 
// 
//Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
// 
//
// Note:
//The length of path between two nodes is represented by the number of edges bet
//ween them.
// Related Topics Tree

package leetcode.editor.en;

import leetcode.common.TreeNode;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
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
        private int diameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            diameter = 0;
            depth(root);
            return diameter;
        }

        private int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int l = depth(root.left);
            int r = depth(root.right);
            diameter = Math.max(diameter, l + r);
            return Math.max(l, r) + 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
