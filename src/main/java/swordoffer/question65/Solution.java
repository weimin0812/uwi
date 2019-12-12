package swordoffer.question65;

public class Solution {
    //    请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
//    路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
//    如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
//    例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
//    但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
    public static void main(String[] args) {
        String matrix = "abcesfcsadee";
        String str = "bcced";
        Solution solution = new Solution();
        boolean has = solution.hasPath(matrix.toCharArray(), 3, 4, str.toCharArray());
        System.out.println(has);
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] visited = new boolean[rows][cols];
                if (hasPath(matrix, i, j, rows, cols, visited, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPath(char[] matrix, int i, int j, int rows, int cols, boolean[][] visited, char[] str, int strIndex) {
        if (i >= rows || i < 0 || j >= cols || j < 0 || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        int matrixIndex = i * cols + j;
        if (matrix[matrixIndex] != str[strIndex]) {
            return false;
        }

        if (strIndex == str.length - 1) {
            return true;
        }

        return hasPath(matrix, i + 1, j, rows, cols, visited, str, strIndex + 1) ||
                hasPath(matrix, i - 1, j, rows, cols, visited, str, strIndex + 1) ||
                hasPath(matrix, i, j + 1, rows, cols, visited, str, strIndex + 1) ||
                hasPath(matrix, i, j - 1, rows, cols, visited, str, strIndex + 1);
    }


}
