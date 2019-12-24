//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below). 
//
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below). 
//
// Now consider if some obstacles are added to the grids. How many unique paths would there be? 
//
// 
//
// An obstacle and empty space is marked as 1 and 0 respectively in the grid. 
//
// Note: m and n will be at most 100. 
//
// Example 1: 
//
// 
//Input:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//Output: 2
//Explanation:
//There is one obstacle in the middle of the 3x3 grid above.
//There are two ways to reach the bottom-right corner:
//1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right
// 
// Related Topics Array Dynamic Programming
package leetcode.editor.en;

public class UniquePathsIi {

    public static void main(String[] args) {
        Solution solution = new UniquePathsIi().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid == null || obstacleGrid[0][0] == 1) {
                return 0;
            }
            int r = obstacleGrid.length, c = obstacleGrid[0].length;
            int[][] dp = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                    } else {
                        if (obstacleGrid[i][j] == 1) {
                            dp[i][j] = 0;
                        } else {
                            dp[i][j] = (j - 1 >= 0 ? dp[i][j - 1] : 0) + (i - 1 >= 0 ? dp[i - 1][j] : 0);
                        }
                    }
                }
            }
            return dp[r - 1][c - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
