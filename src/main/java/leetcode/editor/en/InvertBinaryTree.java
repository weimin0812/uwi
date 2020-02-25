//Invert a binary tree. 
//
// Example: 
//
// Input: 
//
// 
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// Output: 
//
// 
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// Trivia: 
//This problem was inspired by this original tweet by Max Howell: 
//
// Google: 90% of our engineers use the software you wrote (Homebrew), but you c
//an’t invert a binary tree on a whiteboard so f*** off. 
// Related Topics Tree

package leetcode.editor.en;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

 public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        TreeNode current = root;
        if (current == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(current);
        while (!queue.isEmpty()) {
            current = queue.poll();
            TreeNode t = current.left;
            current.left = current.right;
            current.right = t;
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
