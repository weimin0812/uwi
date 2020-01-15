//Given a binary tree, each node has value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit. For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13. 
//
// For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. 
//
// Return the sum of these numbers. 
//
// 
//
// Example 1: 
//
// 
//
// 
//Input: [1,0,1,0,1,0,1]
//Output: 22
//Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
// 
//
// 
//
// Note: 
//
// 
// The number of nodes in the tree is between 1 and 1000. 
// node.val is 0 or 1. 
// The answer will not exceed 2^31 - 1. 
// 
// Related Topics Tree
package leetcode.editor.en;

import leetcode.common.TreeNode;
import leetcode.common.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfRootToLeafBinaryNumbers {

    // todo sum of root to leaf binary numbers
    public static void main(String[] args) {
        Solution solution = new SumOfRootToLeafBinaryNumbers().new Solution();
        TreeNode treeNode = TreeUtil.toTree(Arrays.asList("1", "0", "1", "0", "1", "0", "1", "#", "#", "#", "#", "#", "#", "#", "#"));
        solution.sumRootToLeaf(treeNode);
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
        public int sumRootToLeaf(TreeNode root) {
            ArrayList<List<Integer>> ret = new ArrayList<>();
            dfs(root, new ArrayList<>(), ret);
            int total = 0;
            for (List<Integer> list : ret) {
                int sum = 0;
                for (Integer n : list) {
                    sum = sum * 2 + n;
                }
                total += sum;
            }
            return total;
        }

        private void dfs(TreeNode root, ArrayList<Integer> list, ArrayList<List<Integer>> ret) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            if (root.left == null && root.right == null) {
                ret.add(new ArrayList<>(list));
                return;
            }
            if (root.left != null) {
                dfs(root.left, list, ret);
                list.remove(list.size() - 1);
            }
            if (root.right != null) {
                dfs(root.right, list, ret);
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
