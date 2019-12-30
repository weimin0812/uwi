//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area. 
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
            int[][] dp = new int[matrix.length][matrix[0].length];
            // dp[i][j] = matrix[i][j] == '1'?0:Math.min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])+1
            int ret = 0;
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    if (i == 0) {
                        dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    } else if (j == 0) {
                        dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    } else {
                        dp[i][j] = matrix[i][j] == '1' ? Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1 : 0;
                    }
                    ret = Math.max(ret, dp[i][j]);
                }
            }
            return ret*ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
