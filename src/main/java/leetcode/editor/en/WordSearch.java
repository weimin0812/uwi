//Given a 2D board and a word, find if the word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once. 
//
// Example: 
//
// 
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//Given word = "ABCCED", return true.
//Given word = "SEE", return true.
//Given word = "ABCB", return false.
// 
// Related Topics Array Backtracking
package leetcode.editor.en;

public class WordSearch {

    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (dfs(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j]) {
                return false;
            }
            visited[i][j] = true;
            if (index == word.length() - 1 ||
                    dfs(board, word, i + 1, j, index + 1, visited) ||
                    dfs(board, word, i - 1, j, index + 1, visited) ||
                    dfs(board, word, i, j + 1, index + 1, visited) ||
                    dfs(board, word, i, j - 1, index + 1, visited)
            ) {
                return true;
            }
            visited[i][j] = false;
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
