package 最热100题.股票系列问题._188_买卖股票的最佳时机IV;

/**
 * 股票系列问题
 * https://leetcode-cn.com/circle/article/qiAgHn/
 *
 * */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0)
            return 0;
        int len = prices.length;
        if (k >= len >> 1) {
            return maxProfit(prices);
        }
        int[][][] dp = new int[len][k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = k; j > 0; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0];


    }

    //当k>=临界值时，就相当于第二种情况
    private int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int len = prices.length;
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
