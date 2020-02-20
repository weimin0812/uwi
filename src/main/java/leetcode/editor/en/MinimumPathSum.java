//Given a m x n grid filled with non-negative numbers, find a path from top left
// to bottom right which minimizes the sum of all numbers along its path. 
//
// Note: You can only move either down or right at any point in time. 
//
// Example: 
//
// 
//Input:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//Output: 7
//Explanation: Because the path 1→3→1→1→1 minimizes the sum.
// 
// Related Topics Array Dynamic Programming

package leetcode.editor.en;

public class MinimumPathSum {

    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            //dp[i][j] = grid[i][j] + Math.min(dp[i][j-1],dp[i-1][j])
            int[][] dp = new int[grid.length][grid[0].length];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = grid[0][0];
                    } else {
                        dp[i][j] = grid[i][j] + Math.min(j - 1 >= 0 ? dp[i][j - 1] : Integer.MAX_VALUE, i - 1 >= 0 ? dp[i - 1][j] : Integer.MAX_VALUE);
                    }
                }
            }
            return dp[dp.length - 1][dp[0].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
