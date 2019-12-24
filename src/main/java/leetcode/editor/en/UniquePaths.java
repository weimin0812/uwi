//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below). 
//
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below). 
//
// How many possible unique paths are there? 
//
// 
//Above is a 7 x 3 grid. How many possible unique paths are there? 
//
// Note: m and n will be at most 100. 
//
// Example 1: 
//
// 
//Input: m = 3, n = 2
//Output: 3
//Explanation:
//From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//1. Right -> Right -> Down
//2. Right -> Down -> Right
//3. Down -> Right -> Right
// 
//
// Example 2: 
//
// 
//Input: m = 7, n = 3
//Output: 28 
// Related Topics Array Dynamic Programming
package leetcode.editor.en;

public class UniquePaths {

    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            // dp[i][j]=dp[i][j-1] + dp[i-1][j]
            int[][] dp = new int[m][n];
            dp[0][0] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!(i == 0 && j == 0)) {
                        dp[i][j] = (j - 1 >= 0 ? dp[i][j - 1] : 0) + (i - 1 >= 0 ? dp[i - 1][j] : 0);
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
