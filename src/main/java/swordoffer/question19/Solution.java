package swordoffer.question19;

import java.util.ArrayList;

public class Solution {
    // 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
    // 例如，如果输入如下4 X 4矩阵：
    // 1  2  3  4
    // 5  6  7  8
    // 9  10 11 12
    // 13 14 15 16
    // 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ret;
        }
        int left = 0, right = matrix[0].length - 1, up = 0, bottom = matrix.length - 1;
        while (left <= right && up <= bottom) {
            // fix up from left to right
            for (int i = left; i <= right; i++) {
                ret.add(matrix[up][i]);
            }

            // fix right from up+1 to bottom
            for (int i = up + 1; i <= bottom; i++) {
                ret.add(matrix[i][right]);
            }

            // fix bottom from right-1 to left
            if (up != bottom) {
                for (int i = right - 1; i >= left; i--) {
                    ret.add(matrix[bottom][i]);
                }
            }

            // fix left form bottom-1 to up+1
            if (right != left) {
                for (int i = bottom - 1; i >= up + 1; i--) {
                    ret.add(matrix[i][left]);
                }
            }

            left++;
            right--;
            up++;
            bottom--;
        }

        return ret;
    }
}
