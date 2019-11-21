package swordoffer.question24;

import swordoffer.common.TreeNode;

import java.util.ArrayList;

public class Solution {
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    // 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
    // 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    // (注意: 在返回值的list中，数组长度大的数组靠前)
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return ret;
        }
        findPath(root, target, 0, new ArrayList<Integer>());
        return ret;
    }

    private void findPath(TreeNode root, int target, int sum, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        sum += root.val;
        list.add(root.val);
        if (sum == target && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(list));
        }
        findPath(root.left, target, sum, list);
        findPath(root.right, target, sum, list);
        list.remove(list.size() - 1);
    }
}
