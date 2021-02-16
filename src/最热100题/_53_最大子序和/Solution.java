package 最热100题._53_最大子序和;

/**
 * 动态规划
 * dp[]:表示当前下标下最大子序和
 * 转移方程：dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
 * */
public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //状态转移方程
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (max < dp[i])
                max = dp[i];
        }
        return max;
    }
}
