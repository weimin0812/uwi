//Given a binary tree, determine if it is a valid binary search tree (BST). 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
//
// Example 1: 
//
// 
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
// Related Topics Tree Depth-first Search

package leetcode.editor.en;

import leetcode.common.TreeNode;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
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
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }
        private boolean isValidBST(TreeNode root, Integer min, Integer max) {
            if (root == null) {
                return true;
            }
            int val = root.val;
            if (min != null && val <= min) {
                return false;
            }
            if (max != null && val >= max) {
                return false;
            }
            return isValidBST(root.left, min, val) &&
                    isValidBST(root.right, val, max);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
