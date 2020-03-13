//Say you have an array for which the ith element is the price of a given stock 
//on day i. 
//
// Design an algorithm to find the maximum profit. You may complete at most two 
//transactions. 
//
// Note: You may not engage in multiple transactions at the same time (i.e., you
// must sell the stock before you buy again). 
//
// Example 1: 
//
// 
//Input: [3,3,5,0,0,3,1,4]
//Output: 6
//Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 
//3-0 = 3.
//             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), prof
//it = 4-1 = 3. 
//
// Example 2: 
//
// 
//Input: [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//             Note that you cannot buy on day 1, buy on day 2 and sell them lat
//er, as you are
//             engaging multiple transactions at the same time. You must sell be
//fore buying again.
// 
//
// Example 3: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0. 
// Related Topics Array Dynamic Programming

package leetcode.editor.en;

public class BestTimeToBuyAndSellStockIii {

    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int k = 2, n = prices.length;
            int[][][] dp = new int[n][k + 1][2];
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= k; j++) {
                    dp[i][j][0] = Math.max(i - 1 >= 0 ? dp[i - 1][j][0] : 0, (i - 1 >= 0 ? dp[i - 1][j][1] : Integer.MIN_VALUE) + prices[i]);
                    dp[i][j][1] = Math.max(i - 1 >= 0 ? dp[i - 1][j][1] : Integer.MIN_VALUE, (i - 1 >= 0 ? dp[i - 1][j - 1][0] : 0) - prices[i]);
                }
            }
            return dp[n - 1][k][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
