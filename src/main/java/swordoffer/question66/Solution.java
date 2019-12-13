package swordoffer.question66;

public class Solution {
    //    地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
//    每一次只能向左，右，上，下四个方向移动一格，
//    但是不能进入行坐标和列坐标的数位之和大于k的格子。
//    例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
//    但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
//    请问该机器人能够达到多少个格子？

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return movingCount(0, 0, rows, cols, threshold, visited);
    }

    private int movingCount(int i, int j, int rows, int cols, int threshold, boolean[][] visited) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j] || !canEnter(i, j, threshold)) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + movingCount(i + 1, j, rows, cols, threshold, visited) +
                movingCount(i - 1, j, rows, cols, threshold, visited) +
                movingCount(i, j + 1, rows, cols, threshold, visited) +
                movingCount(i, j - 1, rows, cols, threshold, visited);
    }

    private boolean canEnter(int i, int j, int threshold) {
        return digitsSum(i) + digitsSum(j) <= threshold;
    }

    private int digitsSum(int i) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }

}
