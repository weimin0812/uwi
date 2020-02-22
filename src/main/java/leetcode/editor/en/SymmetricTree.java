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
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            q.offer(root);
            while (!q.isEmpty()) {
                TreeNode n1 = q.poll();
                TreeNode n2 = q.poll();
                if (n1 == null || n2 == null) {
                    if (n1 == n2) {
                        continue;
                    } else {
                        return false;
                    }
                }
                if (n1.val != n2.val) {
                    return false;
                }
                q.offer(n1.left);
                q.offer(n2.right);
                q.offer(n1.right);
                q.offer(n2.left);
            }
            return true;
        }

        private boolean isSymmetric(TreeNode l, TreeNode r) {
            if (l == null || r == null) {
                return l == r;
            }
            return l.val == r.val &&
                    isSymmetric(l.left, r.right) &&
                    isSymmetric(l.right, r.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
