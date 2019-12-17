package leetcode.dp.easy.question0121;

public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices == null || prices.length < 2) {
            return maxProfit;
        }
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
