package 最热100题._32_最长有效括号;

/**
 * s[i]=')' 且s[i-1]='(' 则dp[i] =dp[i-2]+2 ;
 * s[i]=')' 且s[i-2]=')'
 * 若 i - dp[i-1]-1 为'(' 则 dp[i] = dp[i-1]+dp[i-dp[i-1]-2]+2   dp[i-1]是前一个的有效长度 ,+2是现在的括号匹配的基础长度
 */
public class Solution_DP {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int ans = 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 > 0 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }


}
