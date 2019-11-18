package swordoffer.question04;

import swordoffer.common.TreeNode;

public class Solution {
    // 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
    // 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    // 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        // 前序遍历 根 左 右
        // 中序遍历 左 根 右
        if (pre == null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length) {
            return null;
        }

        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int rootIndexOfInOrder = inStart;
        for (; rootIndexOfInOrder <= inEnd; rootIndexOfInOrder++) {
            if (in[rootIndexOfInOrder] == pre[preStart]) {
                break;
            }
        }
        int leftLength = rootIndexOfInOrder - inStart;
        root.left = reConstructBinaryTree(pre, preStart + 1, preStart + leftLength, in, inStart, rootIndexOfInOrder - 1);
        root.right = reConstructBinaryTree(pre, preStart + leftLength + 1, preEnd, in, rootIndexOfInOrder + 1, inEnd);
        return root;
    }

}
