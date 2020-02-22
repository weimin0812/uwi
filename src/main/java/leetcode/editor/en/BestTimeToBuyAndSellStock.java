//Say you have an array for which the ith element is the price of a given stock on day i. 
//
// If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit. 
//
// Note that you cannot sell a stock before you buy one. 
//
// Example 1: 
//
// 
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying price.
// 
//
// Example 2: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
// Related Topics Array Dynamic Programming
package leetcode.editor.en;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            //dp[i][k][0] = dp[i-1][k][0], dp[i-1][k][1]+prices[i]
            //dp[i][k][1] = dp[i-1][k][1], dp[i-1][k-1][0]-prices[i]
            //k = 1
            // dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i])
            // dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i])
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int[][] dp = new int[prices.length][2];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = Math.max(i >= 1 ? dp[i - 1][0] : 0, (i >= 1 ? dp[i - 1][1] : Integer.MIN_VALUE) + prices[i]);
                dp[i][1] = Math.max(i >= 1 ? dp[i - 1][1] : Integer.MIN_VALUE, -prices[i]);
            }
            return dp[dp.length - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
