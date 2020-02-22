//Given a binary tree, flatten it to a linked list in-place. 
//
// For example, given the following tree: 
//
// 
//    1
//   / \
//  2   5
// / \   \
//3   4   6
// 
//
// The flattened tree should look like: 
//
// 
//1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// 
// Related Topics Tree Depth-first Search

package leetcode.editor.en;

import leetcode.common.TreeNode;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
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
        public void flatten(TreeNode root) {
            // 先序遍历根左右的迭代实现，注意入栈的顺序
            if (root == null) {
                return;
            }
            TreeNode current = root, pre = null;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(current);
            while (!stack.isEmpty()) {
                current = stack.pop();
                if (pre == null) {
                    pre = current;
                } else {
                    pre.right = current;
                    pre.left = null;
                    pre = current;
                }
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
