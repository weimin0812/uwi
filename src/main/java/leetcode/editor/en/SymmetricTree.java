//Given a binary tree, check whether it is a mirror of itself (ie, symmetric aro
//und its center). 
//
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric: 
//
// 
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// But the following [1,2,2,null,3,null,3] is not: 
//
// 
//    1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// Note: 
//Bonus points if you could solve it both recursively and iteratively. 
// Related Topics Tree Depth-first Search Breadth-first Search

package leetcode.editor.en;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode t1 = queue.poll();
                TreeNode t2 = queue.poll();
                if (t1 == null || t2 == null) {
                    if (t1 == t2) {
                        continue;
                    } else {
                        return false;
                    }
                }
                if (t1.val != t2.val) {
                    return false;
                }
                queue.offer(t1.left);
                queue.offer(t2.right);
                queue.offer(t1.right);
                queue.offer(t2.left);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
