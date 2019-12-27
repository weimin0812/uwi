//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below. 
//
// For example, given the following triangle 
//
// 
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
//
// Note: 
//
// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
// Related Topics Array Dynamic Programming
package leetcode.editor.en;

import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int[][] dp = new int[triangle.size()][triangle.size()];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j <= i; j++) {
                    Integer current = triangle.get(i).get(j);
                    if (i == 0 && j == 0) {
                        dp[i][j] = current;
                    } else {
                        // 从正上方来或斜上方来
                        if (j == 0) {
                            dp[i][j] = current + dp[i - 1][j];
                        } else if (i == j) {
                            dp[i][j] = current + dp[i - 1][j-1];
                        }else{
                            dp[i][j] = current + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                        }
                    }
                }
            }
            int ret = dp[dp.length - 1][0];
            for (int i : dp[dp.length - 1]) {
                ret = Math.min(ret, i);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
