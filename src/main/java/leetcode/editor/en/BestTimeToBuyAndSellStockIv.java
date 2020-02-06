//Say you have an array for which the i-th element is the price of a given stock
// on day i. 
//
// Design an algorithm to find the maximum profit. You may complete at most k tr
//ansactions. 
//
// Note: 
//You may not engage in multiple transactions at the same time (ie, you must sel
//l the stock before you buy again). 
//
// Example 1: 
//
// 
//Input: [2,4,1], k = 2
//Output: 2
//Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 
//4-2 = 2.
// 
//
// Example 2: 
//
// 
//Input: [3,2,6,5,0,3], k = 2
//Output: 7
//Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 
//6-2 = 4.
//             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), prof
//it = 3-0 = 3.
// 
// Related Topics Dynamic Programming

package leetcode.editor.en;

public class BestTimeToBuyAndSellStockIv {

    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIv().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length == 0 || k <= 0) {
                return 0;
            }
            if (k > prices.length / 2) {
                return maxProfit(prices);
            }
            int[][][] dp = new int[prices.length][k + 1][2];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 1; j <= k; j++) {
                    dp[i][j][0] = Math.max(i - 1 >= 0 ? dp[i - 1][j][0] : 0, (i - 1 >= 0 ? dp[i - 1][j][1] : Integer.MIN_VALUE) + prices[i]);
                    dp[i][j][1] = Math.max(i - 1 >= 0 ? dp[i - 1][j][1] : Integer.MIN_VALUE, ((i - 1 >= 0 && j > 1) ? dp[i - 1][j - 1][0] : 0) - prices[i]);
                }
            }
            return dp[dp.length - 1][k][0];
        }

        private int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            for (int i = 0; i < n; i++) {
                dp[i][0] = Math.max(i - 1 >= 0 ? dp[i - 1][0] : 0, (i - 1 >= 0 ? dp[i - 1][1] : Integer.MIN_VALUE) + prices[i]);
                dp[i][1] = Math.max(i - 1 >= 0 ? dp[i - 1][1] : Integer.MIN_VALUE, (i - 1 >= 0 ? dp[i - 1][0] : 0) - prices[i]);
            }
            return dp[n - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
