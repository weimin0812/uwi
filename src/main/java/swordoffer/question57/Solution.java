package swordoffer.question57;

import swordoffer.common.TreeLinkNode;

public class Solution {
    //    给定一个二叉树和其中的一个结点，
//    请找出中序遍历顺序的下一个结点并且返回。
//    注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
//    用例:
//    {8,6,10,5,7,9,11},8
//    对应输出应该为:9
//    你的输出为:5
//             8
//         6      10
//       5   7  9    11
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // in order:left root right
        // if has right
        // else
        TreeLinkNode current = pNode;
        if (current == null) {
            return null;
        }
        if (current.right != null) {
            current = current.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        }
        while (current.next != null && current.next.left != current) {
            current = current.next;
        }
        return current.next;
    }
}
