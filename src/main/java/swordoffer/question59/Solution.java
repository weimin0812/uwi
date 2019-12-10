package swordoffer.question59;

import swordoffer.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // 请实现一个函数按照之字形打印二叉树，
    // 即第一行按照从左到右的顺序打印，
    // 第二层按照从右至左的顺序打印，
    // 第三行按照从左到右的顺序打印，其他行以此类推。
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        TreeNode current = pRoot;
        if (current == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(current);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                current = queue.poll();
                if (depth % 2 == 1) {
                    list.add(current.val);
                } else {
                    list.add(0, current.val);
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }

            }
            ret.add(list);

        }
        return ret;
    }
}
