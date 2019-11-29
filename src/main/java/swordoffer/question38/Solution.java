package swordoffer.question38;

import swordoffer.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // 输入一棵二叉树，求该树的深度。
    // 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
    public int TreeDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        TreeNode current = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(current);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        return depth;
    }
}
