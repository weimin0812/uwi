package swordoffer.question23;

public class Solution {
    // 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
    // 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
    public boolean VerifySquenceOfBST(int[] sequence) {
        // post order left right root
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean VerifySquenceOfBST(int[] sequence, int l, int h) {
        if (l >= h) {
            return true;
        }
        int breakIndex = l;
        for (; breakIndex < h; breakIndex++) {
            if (sequence[breakIndex] > sequence[h]) {
                break;
            }
        }
        for (int i = breakIndex; i < h; i++) {
            if (sequence[i] < sequence[h]) {
                return false;
            }
        }
        return VerifySquenceOfBST(sequence, l, breakIndex - 1) && VerifySquenceOfBST(sequence, breakIndex, h - 1);
    }
}
