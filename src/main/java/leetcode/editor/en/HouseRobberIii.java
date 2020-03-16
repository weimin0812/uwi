//The thief has found himself a new place for his thievery again. There is only 
//one entrance to this area, called the "root." Besides the root, each house has o
//ne and only one parent house. After a tour, the smart thief realized that "all h
//ouses in this place forms a binary tree". It will automatically contact the poli
//ce if two directly-linked houses were broken into on the same night. 
//
// Determine the maximum amount of money the thief can rob tonight without alert
//ing the police. 
//
// Example 1: 
//
// 
//Input: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//Output: 7 
//Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7. 
//
// Example 2: 
//
// 
//Input: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//Output: 9
//Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
// Related Topics Tree Depth-first Search

package leetcode.editor.en;

import leetcode.common.TreeNode;

public class HouseRobberIii {

    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
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
        public int rob(TreeNode root) {
            int[] ret = robOrNot(root);
            return Math.max(ret[0], ret[1]);
        }

        private int[] robOrNot(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }
            int[] left = robOrNot(root.left);
            int[] right = robOrNot(root.right);
            return new int[]{Math.max(left[0], left[1]) + Math.max(right[0], right[1]), root.val + left[0] + right[0]};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
