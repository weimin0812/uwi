//Given a binary tree and a sum, find all root-to-leaf paths where each path's s
//um equals the given sum. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given the below binary tree and sum = 22, 
//
// 
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \    / \
//7    2  5   1
// 
//
// Return: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics Tree Depth-first Search

package leetcode.editor.en;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumIi {

    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
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
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> ret = new ArrayList<>();
            pathSum(root, sum, ret, new ArrayList<Integer>());
            return ret;
        }

        private void pathSum(TreeNode root, int sum, List<List<Integer>> ret, ArrayList<Integer> list) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            sum -= root.val;
            if (sum == 0 && root.right == null && root.left == null) {
                ret.add(new ArrayList<>(list));
            }
            pathSum(root.left, sum, ret, list);
            pathSum(root.right, sum, ret, list);
            list.remove(list.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
