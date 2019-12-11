package swordoffer.question61;

import swordoffer.common.ListNode;
import swordoffer.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //    请实现两个函数，分别用来序列化和反序列化二叉树
//
//    二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
//
//    二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        TreeNode current = root;
        if (current == null) {
            return sb.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(current);
        while (!queue.isEmpty()) {
            current = queue.poll();
            sb.append(current == null ? "#!" : current.val + "!");
            if (current != null) {
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] strings = str.split("!");
        TreeNode[] treeNodes = new TreeNode[strings.length];
        for (int i = 0; i < treeNodes.length; i++) {
            treeNodes[i] = strings[i].equals("#") ? null : new TreeNode(Integer.parseInt(strings[i]));
        }

        for (int i = 0, j = 1; j < strings.length; i++) {
            if (treeNodes[i] != null) {
                treeNodes[i].left = treeNodes[j++];
                treeNodes[i].right = treeNodes[j++];
            }
        }
        return treeNodes[0];
    }

    public static void main(String[] args) {
        String s = "1!2!3!";
        String[] split = s.split("!");
        s = "1";
        String[] split1 = s.split("!");
        int i = 0;
    }
}
