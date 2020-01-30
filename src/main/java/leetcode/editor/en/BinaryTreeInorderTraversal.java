//Given a binary tree, return the inorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,3,2] 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics Hash Table Stack Tree
package leetcode.editor.en;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            inorder(root, ret);
            return ret;
//            TreeNode current = root;
//            Stack<TreeNode> stack = new Stack<>();
//            List<Integer> list = new ArrayList<>();
//            while (current != null || !stack.isEmpty()) {
//                while (current != null) {
//                    stack.push(current);
//                    current = current.left;
//                }
//                current = stack.pop();
//                list.add(current.val);
//                current = current.right;
//            }
//            return list;
        }

        private void inorder(TreeNode root, List<Integer> ret) {
            if (root == null) {
                return;
            }
            inorder(root.left, ret);
            ret.add(root.val);
            inorder(root.right, ret);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
