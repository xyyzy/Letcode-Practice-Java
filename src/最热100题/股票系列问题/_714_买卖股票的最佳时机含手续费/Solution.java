package 最热100题.股票系列问题._714_买卖股票的最佳时机含手续费;

/**
 * 情况同 2  交易次数不限，但是有手续费，手续费在每次交易(买入和卖出 合起来算一次) 扣除手续费
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0)
            return 0;
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;//买入的时候扣除手续费
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[len-1][0];
    }
}
