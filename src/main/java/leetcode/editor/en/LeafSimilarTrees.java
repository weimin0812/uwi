//Consider all the leaves of a binary tree. From left to right order, the values of those leaves form a leaf value sequence. 
//
// 
//
// For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8). 
//
// Two binary trees are considered leaf-similar if their leaf value sequence is the same. 
//
// Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar. 
//
// 
//
// Note: 
//
// 
// Both of the given trees will have between 1 and 100 nodes. 
// 
// Related Topics Tree Depth-first Search
package leetcode.editor.en;

import com.sun.org.apache.xpath.internal.objects.XNull;
import swordoffer.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    public static void main(String[] args) {
        Solution solution = new LeafSimilarTrees().new Solution();
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
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            dfs(root1, list1);
            dfs(root2, list2);
            return list1.equals(list2);
        }

        private void dfs(TreeNode node, List<Integer> list) {
            if (node != null) {
                dfs(node.left, list);
                if (node.left == null && node.right == null) {
                    list.add(node.val);
                }
                dfs(node.right, list);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
