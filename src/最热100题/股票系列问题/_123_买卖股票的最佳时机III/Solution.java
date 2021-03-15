package 最热100题.股票系列问题._123_买卖股票的最佳时机III;

public class Solution {
    /**
     * dp[i][k][j]  表示第i天买了k次之后持有j份股份
     * */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][][] dp = new int[len][3][2];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
        }
        return dp[len-1][2][0];
    }
}
