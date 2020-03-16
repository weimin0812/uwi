//Given a 2D binary matrix filled with 0's and 1's, find the largest square cont
//aining only 1's and return its area. 
//
// Example: 
//
// 
//Input: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//Output: 4
// Related Topics Dynamic Programming

package leetcode.editor.en;

public class MaximalSquare {

    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            int ret = 0;
            int n = matrix.length;
            int m = matrix[0].length;
            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(i - 1 >= 0 ? dp[i - 1][j] : 0, Math.min(j - 1 >= 0 ? dp[i][j - 1] : 0, i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] : 0)) + 1;
                        ret = Math.max(ret, dp[i][j] * dp[i][j]);
                    }
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
