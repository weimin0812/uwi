//Given preorder and inorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics Array Tree Depth-first Search

package leetcode.editor.en;

import leetcode.common.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
            if (pre == null || preStart > preEnd || in == null || inStart > inEnd) {
                return null;
            }
            TreeNode node = new TreeNode(pre[preStart]);
            int i = inStart;
            for (; i <= inEnd; i++) {
                if (in[i] == pre[preStart]) {
                    break;
                }
            }
            int leftLen = i - inStart;
            node.left = buildTree(pre, preStart + 1, preStart + leftLen, in, inStart, i - 1);
            node.right = buildTree(pre, preStart + leftLen + 1, preEnd, in, i + 1, inEnd);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
