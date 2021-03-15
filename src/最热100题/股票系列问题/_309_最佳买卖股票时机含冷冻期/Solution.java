package 最热100题.股票系列问题._309_最佳买卖股票时机含冷冻期;

/**
 * 因为可以多次买卖，所以与情况2 相同，但是有冷冻期，所以dp第二个状态转移方程中不再是T[i - 1][k][0] 而是T[i - 2][k][0]
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], (i > 2 ? dp[i - 2][0] : 0) - prices[i]);
        }
        return dp[len-1][0];

    }
}
