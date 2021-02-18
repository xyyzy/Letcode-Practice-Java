package 最热100题._70_爬楼梯;

/**
 * 动态规划
 * dp[i] =  dp[i-1]+dp[i-2]
 * 在这题中对dp[0] 没有讨论的意义
 */
public class Solution {
    public int climbStairs(int n) {
        if (n <= 1)
            return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
