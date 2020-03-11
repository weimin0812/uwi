//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle c
//ontaining only 1's and return its area. 
//
// Example: 
//
// 
//Input:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//Output: 6
// 
// Related Topics Array Hash Table Dynamic Programming Stack

package leetcode.editor.en;

public class MaximalRectangle {

    public static void main(String[] args) {
        Solution solution = new MaximalRectangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int ret = 0;
            int[][] dp = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    if (matrix[i][j] == '1') {
                        if (i == 0 && j == 0) {
                            dp[i][j] = 1;
                        } else {
                            int a = i - 1 >= 0 ? dp[i - 1][j] : Integer.MAX_VALUE;
                            int b = j - 1 >= 0 ? dp[i][j - 1] : Integer.MAX_VALUE;
                            int c = i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                            dp[i][j] = Math.min(a, Math.min(b, c)) + 1;
                        }
                        ret = Math.max(ret, dp[i][j] * dp[i][j]);
                    }
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
