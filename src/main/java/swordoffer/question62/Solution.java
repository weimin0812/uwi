package swordoffer.question62;

import swordoffer.common.TreeNode;

import java.util.Stack;

public class Solution {
    //    用例:
//    {8,6,10,5,7,9,11},1
//    对应输出应该为:     5
//    你的输出为:     6
    public static void main(String[] args) {
        int[] array = {8, 6, 10, 5, 7, 9, 11};
        TreeNode[] treeNodes = new TreeNode[array.length];
        for (int i = 0; i < treeNodes.length; i++) {
            treeNodes[i] = new TreeNode(array[i]);
        }
        for (int i = 0, j = 1; j < treeNodes.length; i++) {
            treeNodes[i].left = treeNodes[j++];
            treeNodes[i].right = treeNodes[j++];
        }
        Solution solution = new Solution();
        solution.KthNode(treeNodes[0], 1);
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        TreeNode current = pRoot;
        if (current == null || k < 1) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            count++;
            if (count == k) {
                return current;
            }
            current = current.right;
        }

        return null;
    }
}
