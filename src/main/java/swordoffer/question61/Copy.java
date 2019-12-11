package swordoffer.question61;

import swordoffer.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Copy {
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
                sb.append(node.val + ",");
            } else {
                sb.append("#" + ",");
            }
        }
        if (sb.length() != 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        TreeNode head = null;
        if (str == null || str.length() == 0)
            return head;
        String[] nodes = str.split(",");
        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            if (!nodes[i].equals("#"))
                treeNodes[i] = new TreeNode(Integer.valueOf(nodes[i]));
        }
        for (int i = 0, j = 1; j < treeNodes.length; i++) {
            if (treeNodes[i] != null) {
                treeNodes[i].left = treeNodes[j++];
                treeNodes[i].right = treeNodes[j++];
            }
        }
        return treeNodes[0];
    }

    // todo pre order
    String Serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        getSerializeString(root, sb);
        if (sb.length() != 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    void getSerializeString(TreeNode root, StringBuilder sb) {
        if (root == null)
            sb.append("#,");
        else {
            sb.append(root.val + ",");
            getSerializeString(root.left, sb);
            getSerializeString(root.right, sb);
        }
    }

    TreeNode Deserialize1(String str) {
        if (str == null || str.length() == 0 || str.length() == 1)
            return null;
        String[] nodes = str.split(",");
        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            if (!nodes[i].equals("#"))
                treeNodes[i] = new TreeNode(Integer.valueOf(nodes[i]));
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNodes[0]);
        int i = 1;
        while (treeNodes[i] != null) {
            stack.peek().left = treeNodes[i];
            stack.push(treeNodes[i++]);
        }
        while (!stack.isEmpty()) {
            stack.pop().right = treeNodes[++i];
            if (treeNodes[i] != null) {
                stack.push(treeNodes[i++]);
                while (treeNodes[i] != null) {
                    stack.peek().left = treeNodes[i];
                    stack.push(treeNodes[i++]);
                }
            }
        }
        return treeNodes[0];
    }
}

