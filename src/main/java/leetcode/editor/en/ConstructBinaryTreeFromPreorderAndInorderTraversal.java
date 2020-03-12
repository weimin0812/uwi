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
            if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
                return null;
            }
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }
            TreeNode root = new TreeNode(pre[preStart]);
            int rootIndex = inStart;
            for (; rootIndex <= inEnd; rootIndex++) {
                if (in[rootIndex] == pre[preStart]) {
                    break;
                }
            }
            int leftLen = rootIndex - inStart;
            root.left = buildTree(pre, preStart + 1, preStart + leftLen, in, inStart, rootIndex - 1);
            root.right = buildTree(pre, preStart + leftLen + 1, preEnd, in, rootIndex + 1, inEnd);
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
