//You are given a binary tree in which each node contains an integer value. 
//
// Find the number of paths that sum to a given value. 
//
// The path does not need to start or end at the root or a leaf, but it must go 
//downwards
//(traveling only from parent nodes to child nodes). 
//
// The tree has no more than 1,000 nodes and the values are in the range -1,000,
//000 to 1,000,000.
//
// Example:
// 
//root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//Return 3. The paths that sum to 8 are:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3. -3 -> 11
// 
// Related Topics Tree

package leetcode.editor.en;

import leetcode.common.TreeNode;

public class PathSumIii {

    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
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
        public int pathSum(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }

        private int pathSumFrom(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            return (sum == root.val ? 1 : 0) + pathSumFrom(root.left, sum - root.val) +
                    pathSumFrom(root.right, sum - root.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
