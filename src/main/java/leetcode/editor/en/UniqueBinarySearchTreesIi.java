//Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n. 
//
// Example: 
//
// 
//Input: 3
//Output:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//Explanation:
//The above output corresponds to the 5 unique BST's shown below:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
// Related Topics Dynamic Programming Tree
package leetcode.editor.en;

import swordoffer.common.ListNode;
import swordoffer.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesIi {

    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
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
        public List<TreeNode> generateTrees(int n) {
            if (n <= 0) {
                return new LinkedList<>();
            }

            return generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int start, int end) {
            List<TreeNode> allTrees = new LinkedList<>();
            if (start > end) {
                allTrees.add(null);
                return allTrees;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> lefts = generateTrees(start, i - 1);
                List<TreeNode> rights = generateTrees(i + 1, end);
                for (TreeNode l : lefts) {
                    for (TreeNode r : rights) {
                        TreeNode current = new TreeNode(i);
                        current.left = l;
                        current.right = r;
                        allTrees.add(current);
                    }
                }
            }
            return allTrees;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
