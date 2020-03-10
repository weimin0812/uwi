//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below). 
//
// The robot can only move either down or right at any point in time. The robot 
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below). 
//
// How many possible unique paths are there? 
//
// 
//Above is a 7 x 3 grid. How many possible unique paths are there? 
//
// 
// Example 1: 
//
// 
//Input: m = 3, n = 2
//Output: 3
//Explanation:
//From the top-left corner, there are a total of 3 ways to reach the bottom-righ
//t corner:
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
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 100 
// It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9. 
// 
// Related Topics Array Dynamic Programming

package leetcode.editor.en;

public class UniquePaths {

    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = (j - 1 >= 0 ? dp[i][j - 1] : 0) + (i - 1 >= 0 ? dp[i - 1][j] : 0);
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
