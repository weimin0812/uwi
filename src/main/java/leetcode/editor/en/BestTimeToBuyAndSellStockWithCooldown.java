//Say you have an array for which the ith element is the price of a given stock 
//on day i. 
//
// Design an algorithm to find the maximum profit. You may complete as many tran
//sactions as you like (ie, buy one and sell one share of the stock multiple times
//) with the following restrictions: 
//
// 
// You may not engage in multiple transactions at the same time (ie, you must se
//ll the stock before you buy again). 
// After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 
//day) 
// 
//
// Example: 
//
// 
//Input: [1,2,3,0,2]
//Output: 3 
//Explanation: transactions = [buy, sell, cooldown, buy, sell]
// Related Topics Dynamic Programming

package leetcode.editor.en;

public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int n = prices.length;
            int[][] dp = new int[n][2];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = Math.max(i - 1 >= 0 ? dp[i - 1][0] : 0, (i - 1 >= 0 ? dp[i - 1][1] : Integer.MIN_VALUE) + prices[i]);
                dp[i][1] = Math.max(i - 1 >= 0 ? dp[i - 1][1] : Integer.MIN_VALUE, (i - 2 >= 0 ? dp[i - 2][0] : 0) - prices[i]);
            }
            return dp[n - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
