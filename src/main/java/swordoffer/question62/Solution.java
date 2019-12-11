package swordoffer.question62;

import swordoffer.common.TreeNode;

import java.util.Stack;

public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k) {
        TreeNode current = pRoot;
        if (current == null || k < 1) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (current != null || !stack.isEmpty()) {
            while (current.left != null) {
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
