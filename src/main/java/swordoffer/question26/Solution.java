package swordoffer.question26;

import swordoffer.common.TreeNode;

import java.util.Stack;

public class Solution {
    // 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    // 要求不能创建任何新的结点，只能调整树中结点指针的指向。
    public TreeNode Convert(TreeNode pRootOfTree) {
        // left root right in order
        TreeNode current = pRootOfTree, pre = null, ret = null;
        boolean first = true;
        Stack<TreeNode> stack = new Stack();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current.left = pre;
            if (first) {
                ret = current;
                first = false;
            } else {
                pre.right = current;
            }
            pre = current;
            current = current.right;
        }

        return ret;
    }
}
